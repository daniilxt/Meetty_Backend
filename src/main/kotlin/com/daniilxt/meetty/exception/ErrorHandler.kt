package com.daniilxt.meetty.exception

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


// применяется ко всем контроллерам
@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<ApiError> {
        return ResponseEntity(ex.apiError, ex.httpStatus)
    }

    @ExceptionHandler(value = [DataIntegrityViolationException::class])
    fun handlePreconditionFailed(ex: DataIntegrityViolationException): ResponseEntity<ApiError> {
        return ResponseEntity(ApiError(HttpStatus.CONFLICT.value(), "Duplicated entity"), HttpStatus.CONFLICT)
    }
}