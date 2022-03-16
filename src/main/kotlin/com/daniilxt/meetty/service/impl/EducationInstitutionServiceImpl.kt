package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.service.EducationInstitutionService
import org.springframework.stereotype.Service

@Service
class EducationInstitutionServiceImpl : EducationInstitutionService {
    override fun getAll(): List<EducationInstitutionDto> {
        // TODO impl
        return listOf(
            EducationInstitutionDto(id = 1, name = "Политех Петра", location = "Санкт-Петербург, Политехническая 29"),
            EducationInstitutionDto(id = 2, name = "ИТМО", location = "Санкт-Петербург, Кронверский 49")
        )
    }
}