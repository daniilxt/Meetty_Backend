package com.daniilxt.meetty.security.jwt

import com.daniilxt.meetty.exception.InvalidJwtAuthenticationException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    @Qualifier("customUserDetailsService")
    private val userDetailsService: UserDetailsService
) {

    private var secretKey: String = "secret"

    @PostConstruct
    private fun init() {
        secretKey = Base64.getEncoder().encodeToString(jwtProperties.secretKey.toByteArray())
    }

    fun createToken(userName: String, roles: List<String>): String {
        val claims: Claims = Jwts.claims().setSubject(userName)
        val now = Date()
        val validity = Date(now.time + jwtProperties.validityInMs)
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(getSigningKey())
            .compact()
    }

    private fun getSigningKey(): Key {
        val seed = "H2VoPfRg69AEySbyVN2EODjiXBk7w85VZXsi1W5UOns=".toByteArray()
        val key = Keys.hmacShaKeyFor(seed)
        logger.info("Secret key: $key  $seed")
        return key
    }

    fun getUserName(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun validateToken(token: String): Boolean = try {
        val claims = Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
        !claims.body.expiration.before(Date())
    } catch (e: JwtException) {
        throw InvalidJwtAuthenticationException("Expired or invalid token")
    } catch (e: IllegalArgumentException) {
        throw InvalidJwtAuthenticationException("Expired or invalid token")
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(AUTHORIZATION)
        return if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            bearerToken.substring(BEARER_INDEX)
        } else null
    }

    fun getAuthentication(token: String): Authentication? {
        val userDetails = userDetailsService.loadUserByUsername(getUserName(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val BEARER_PREFIX = "Bearer "
        private const val BEARER_INDEX = 7

        private val logger = LoggerFactory.getLogger(JwtAuthEntryPoint::class.java)
    }
}