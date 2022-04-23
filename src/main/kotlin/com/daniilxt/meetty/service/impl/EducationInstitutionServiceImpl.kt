package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.entity.toEducationInstitutionDto
import com.daniilxt.meetty.repository.UniversityRepository
import com.daniilxt.meetty.service.EducationInstitutionService
import org.springframework.stereotype.Service

@Service
class EducationInstitutionServiceImpl(
    private val universityRepository: UniversityRepository
) : EducationInstitutionService {
    override fun getAll(): List<EducationInstitutionDto> {
        return universityRepository.findAll().map {
            it.toEducationInstitutionDto()
        }
    }
}