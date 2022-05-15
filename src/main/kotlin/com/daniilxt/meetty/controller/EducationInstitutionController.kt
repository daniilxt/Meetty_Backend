package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.service.EducationInstitutionService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/add")
    fun save(@RequestBody educationInstitutionDto: EducationInstitutionDto): Long {
        return educationInstitutionService.save(educationInstitutionDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUniversity(@PathVariable("id") id: Long) {
        return educationInstitutionService.deleteById(id)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(EducationInstitutionController::class.java)
    }
}
