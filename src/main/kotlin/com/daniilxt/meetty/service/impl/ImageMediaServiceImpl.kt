package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.exception.AuthException
import com.daniilxt.meetty.exception.MediaException
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.service.ImageMediaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile


@Service
class ImageMediaServiceImpl(
    private val userRepository: UserRepository,
) : ImageMediaService {
    @Transactional
    override fun getUserProfileImage(userEmail: String): ByteArray {
        val user = userRepository.getByEmail(userEmail) ?: throw AuthException.InvalidUser()
        return user.profilePicture ?: throw  MediaException.FileNotFound()
    }

    @Transactional
    override fun getUserProfileByUserId(userId: Long): ByteArray {
        val user = userRepository.getById(userId) ?: throw AuthException.InvalidUser()
        return user.profilePicture ?: throw  MediaException.FileNotFound()
    }

    @Transactional
    override fun saveProfileImage(userEmail: String, file: MultipartFile) {
        val user = userRepository.getByEmail(userEmail) ?: throw AuthException.InvalidUser()
        user.profilePicture = file.bytes
        userRepository.save(user)
    }

    @Transactional
    override fun saveProfileImageByUserId(userId: Long, file: MultipartFile) {
        val user = userRepository.getById(userId) ?: throw AuthException.InvalidUser()
        user.profilePicture = file.bytes
        userRepository.save(user)
    }
}