package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.ProfessionalInterestDto
import com.daniilxt.meetty.entity.toProfessionalInterestDto
import com.daniilxt.meetty.repository.ProfessionalInterestsRepository
import com.daniilxt.meetty.service.ProfessionalInterestsService
import org.springframework.stereotype.Service

@Service
class ProfessionalInterestsServiceImpl(
    private val professionalInterestsRepository: ProfessionalInterestsRepository
) : ProfessionalInterestsService {
    override fun getAll(): List<ProfessionalInterestDto> {
        return professionalInterestsRepository.findAll().map { it.toProfessionalInterestDto() }
    }
}