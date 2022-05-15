package com.daniilxt.meetty.security.jwt

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtSecurityConfigurer(private val jwtTokenProvider: JwtTokenProvider) :
    SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    @Throws(Exception::class)
    override fun configure(builder: HttpSecurity) {
        val filter = JwtFilter(jwtTokenProvider)
        builder.exceptionHandling()
            .authenticationEntryPoint(JwtAuthEntryPoint())
            .and()
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
    }
}
