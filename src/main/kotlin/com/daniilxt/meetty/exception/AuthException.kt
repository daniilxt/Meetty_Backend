package com.daniilxt.meetty.exception

import org.springframework.http.HttpStatus

sealed class AuthException(httpStatus: HttpStatus = HttpStatus.FORBIDDEN, apiError: ApiError) :
    BaseException(httpStatus, apiError) {
    class IncorrectLoginOrPassword(additionalDescription: String = "") : AuthException(
        apiError = ApiError(errorCode = 403, description = "Incorrect login or password")
    )

    class AccountAlreadyExist(additionalDescription: String = "") : AuthException(
        apiError = ApiError(errorCode = 403, description = "Account already exist")
    )

    class InvalidCredentials(additionalDescription: String = "") : AuthException(
        apiError = ApiError(errorCode = 403, description = "Invalid Credentials")
    )

    class UnknownError(additionalDescription: String = "") : AuthException(
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        apiError = ApiError(errorCode = 403, description = "Unknown error")
    )
}