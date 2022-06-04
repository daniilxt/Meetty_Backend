package com.daniilxt.meetty.exception

import org.springframework.http.HttpStatus

sealed class MediaException(httpStatus: HttpStatus = HttpStatus.NOT_FOUND, apiError: ApiError) :
    BaseException(httpStatus, apiError) {
    class FileNotFound(additionalDescription: String = "") : MediaException(
        apiError = ApiError(errorCode = 404, description = "File Not Found")
    )

    class FileAlreadyExist(additionalDescription: String = "") : MediaException(
        apiError = ApiError(errorCode = 404, description = "File already exist")
    )

    class UnknownError(additionalDescription: String = "") : MediaException(
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        apiError = ApiError(errorCode = 404, description = "Unknown error")
    )
}