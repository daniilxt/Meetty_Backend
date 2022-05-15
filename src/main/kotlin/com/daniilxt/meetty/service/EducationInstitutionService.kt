package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.EducationInstitutionDto

interface EducationInstitutionService {
    fun getAll(): List<EducationInstitutionDto>
    fun save(data: EducationInstitutionDto): Long
    fun deleteById(id: Long)
}
