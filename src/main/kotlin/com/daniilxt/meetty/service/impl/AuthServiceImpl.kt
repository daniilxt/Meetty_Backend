package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.exception.AuthException
import com.daniilxt.meetty.exception.EducationException
import com.daniilxt.meetty.repository.*
import com.daniilxt.meetty.request.*
import com.daniilxt.meetty.security.jwt.JwtTokenProvider
import com.daniilxt.meetty.service.AuthService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.KClass

@Service
class AuthServiceImpl(
    private val userDetailsRepository: UserDetailsRepository,
    private val userRepository: UserRepository,
    private val userEducationRepository: UserEducationRepository,
    private val universityRepository: UniversityRepository,
    private val userAchievementRepository: UserAchievementRepository,
    private val userProfessionalInterestRepository: UserProfessionalInterestRepository,
    private val jwtTokenProvider: JwtTokenProvider,
) : AuthService {
    override fun getToken(authRequest: AuthRequest): TokenDto {
        val user = userDetailsRepository.findUserByLogin(authRequest.login) ?: throw AuthException.InvalidCredentials()
        val token = jwtTokenProvider.createToken(
            user.login, emptyList()
        )
        return TokenDto(accessToken = token)
    }

    @Transactional
    override fun save(data: RegistrationRequest): TokenDto {
        if (data.userCredentials.email.isBlank() || data.userCredentials.password.isBlank()) {
            throw AuthException.IncorrectLoginOrPassword()
        }
        val userEntity = saveThrowable(
            throwable = AuthException.AccountAlreadyExist()
        ) { userRepository.save(data.userPersonalInfo.toUserEntity(data.userCredentials.email)) }

        val userUniversityEntity = universityRepository.findByIdOrNull(data.userEducationInfo.instituteId)
            ?: throw EducationException.NotFound()

        saveThrowable(throwable = EducationException.Duplicated()) {
            userEducationRepository.save(
                data.userEducationInfo.toUserEducationEntity(userUniversityEntity, userEntity)
            )
        }
        val registeredUser = saveThrowable(throwable = AuthException.AccountAlreadyExist()) {
            userDetailsRepository.save(data.userCredentials.toUserDetailEntity(userEntity))
        }

        saveThrowable(throwable = AuthException.AccountAlreadyExist()) {
            userProfessionalInterestRepository.saveAll(data.professionalInterest.map {
                it.toUserProfessionalInterestEntity(userEntity)
            })
        }

        saveThrowable(throwable = AuthException.AccountAlreadyExist()) {
            userAchievementRepository.saveAll(data.userAchievements.map { it.toUserAchievementEntity(userEntity) })
        }
        val token = jwtTokenProvider.createToken(registeredUser.login, emptyList())
        return TokenDto(accessToken = token)
    }

    private fun <T> saveThrowable(
        checkedThrowable: KClass<*> = DataIntegrityViolationException::class,
        throwable: Throwable,
        save: () -> T
    ): T {
        return runCatching { save() }
            .onFailure { ex -> if (ex == checkedThrowable) throw throwable }
            .getOrThrow()
    }
}