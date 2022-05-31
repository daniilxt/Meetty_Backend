package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.*
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
    fun save(@RequestBody educationInstitutionDto: EducationInstitutionDto2): Long {
        val coord = educationInstitutionDto.coordinates.split(",").map { it.toFloat() }
        val edu = EducationInstitutionDto(
            name = educationInstitutionDto.name,
            location = LocationInfoDto(
                city = CityDto(name = educationInstitutionDto.city, id = 0),
                address = educationInstitutionDto.address,
                coordinates = CoordinatesDto(latitude = coord[0], longitude = coord[1])
            ),
            logoUri = educationInstitutionDto.logoUri
        )
        return educationInstitutionService.save(edu)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUniversity(@PathVariable("id") id: Long) {
        return educationInstitutionService.deleteById(id)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(EducationInstitutionController::class.java)
    }
}
