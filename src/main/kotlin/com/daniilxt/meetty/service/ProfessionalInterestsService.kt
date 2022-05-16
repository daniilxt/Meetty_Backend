package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.ProfessionalInterestDto

interface ProfessionalInterestsService {
    fun getAll(): List<ProfessionalInterestDto>
}
