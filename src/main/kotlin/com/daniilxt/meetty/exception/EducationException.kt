package com.daniilxt.meetty.exception

import org.springframework.http.HttpStatus

sealed class EducationException(httpStatus: HttpStatus = HttpStatus.NOT_FOUND, apiError: ApiError) :
    BaseException(httpStatus, apiError) {
    class NotFound(additionalDescription: String = "") : EducationException(
        apiError = ApiError(errorCode = 404, description = "Incorrect university id")
    )

    class Duplicated(additionalDescription: String = "") : EducationException(
        httpStatus = HttpStatus.CONFLICT,
        apiError = ApiError(errorCode = 409, description = "Duplicated university info")
    )
}