package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserEducationEntity
import org.springframework.data.repository.CrudRepository

interface UserEducationRepository : CrudRepository<UserEducationEntity, Long> {
    fun getUserEducationEntityByUserId(userId: Long): UserEducationEntity
}