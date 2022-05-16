package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.dto.ProfessionalInterestDto
import com.daniilxt.meetty.service.EducationInstitutionService
import com.daniilxt.meetty.service.ProfessionalInterestsService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/regsteps")
class RegistrationProfileController(
    private val educationInstitutionService: EducationInstitutionService,
    private val professionalInterestsService: ProfessionalInterestsService
) {
    @GetMapping("/edu")
    fun getAllUniversity(): List<EducationInstitutionDto> {
        return educationInstitutionService.getAll()
    }

    @GetMapping("/interests")
    fun getProfessionalInterests(): List<ProfessionalInterestDto> {
        return professionalInterestsService.getAll()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(RegistrationProfileController::class.java)
    }
}