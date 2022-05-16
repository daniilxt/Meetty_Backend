package com.daniilxt.meetty.exception

import org.springframework.http.HttpStatus

class InvalidJwtAuthenticationException(message: String) : BaseException(
    httpStatus = HttpStatus.UNAUTHORIZED, apiError = ApiError(
        HttpStatus.UNAUTHORIZED.value(), message
    )
)
