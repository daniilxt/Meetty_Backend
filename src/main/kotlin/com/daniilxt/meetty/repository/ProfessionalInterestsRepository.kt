package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.ProfessionalInterestEntity
import org.springframework.data.repository.CrudRepository

interface ProfessionalInterestsRepository : CrudRepository<ProfessionalInterestEntity, Long> {
}