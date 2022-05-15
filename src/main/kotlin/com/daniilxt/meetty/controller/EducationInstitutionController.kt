package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.service.EducationInstitutionService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/edu")
class EducationInstitutionController(
    private val educationInstitutionService: EducationInstitutionService
) {
    @GetMapping
    fun getAll(): List<EducationInstitutionDto> {
        logger.info("Attemption")
        return educationInstitutionService.getAll()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(EducationInstitutionController::class.java)
    }
}
