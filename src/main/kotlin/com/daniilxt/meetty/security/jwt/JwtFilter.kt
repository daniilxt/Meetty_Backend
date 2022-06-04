package com.daniilxt.meetty.security.jwt

import com.daniilxt.meetty.exception.InvalidJwtAuthenticationException
import extensions.sendApiError
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtFilter(private val jwtTokenProvider: JwtTokenProvider) : GenericFilterBean() {

    @Throws(IOException::class, ServletException::class, InvalidJwtAuthenticationException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val token: String? = jwtTokenProvider.resolveToken(servletRequest as HttpServletRequest)
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                val auth: Authentication? = jwtTokenProvider.getAuthentication(token)
                SecurityContextHolder.getContext().authentication = auth
                filterChain.doFilter(servletRequest, servletResponse)
            }
        } catch (e: InvalidJwtAuthenticationException) {
            e.message?.let { (servletResponse as HttpServletResponse).sendApiError(it) }
        }
    }
}