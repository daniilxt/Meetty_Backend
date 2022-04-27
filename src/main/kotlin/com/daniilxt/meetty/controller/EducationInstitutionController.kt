package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.service.EducationInstitutionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/edu")
class EducationInstitutionController(
    private val educationInstitutionService: EducationInstitutionService
) {
    @GetMapping
    fun getAll(): List<EducationInstitutionDto> = educationInstitutionService.getAll()
}
