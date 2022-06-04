package com.daniilxt.meetty.security

import com.daniilxt.meetty.security.jwt.JwtAuthEntryPoint
import com.daniilxt.meetty.security.jwt.JwtSecurityConfigurer
import com.daniilxt.meetty.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SpringSecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtAuthEntryPoint: JwtAuthEntryPoint
) : WebSecurityConfigurerAdapter() {

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic().disable()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(*AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
            .and()
            .apply(JwtSecurityConfigurer(jwtTokenProvider))
    }

    companion object {
        private val AUTH_WHITELIST = arrayOf(
            "/api/v1/auth/login",
            "/api/v1/auth/registration",
            "/api/v1/media/image/profile/*",
            "/api/v1/regsteps/**",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "/webjars/**",
        )
    }
}