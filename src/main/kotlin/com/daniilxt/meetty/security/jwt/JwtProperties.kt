package com.daniilxt.meetty.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
class JwtProperties {
    var secretKey = "verySecret"
    var validityInMs: Long = 1800000
}