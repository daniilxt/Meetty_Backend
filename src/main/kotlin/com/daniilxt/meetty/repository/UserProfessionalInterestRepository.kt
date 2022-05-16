package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserProfessionalInterestEntity
import org.springframework.data.repository.CrudRepository

interface UserProfessionalInterestRepository : CrudRepository<UserProfessionalInterestEntity, Long> {
}