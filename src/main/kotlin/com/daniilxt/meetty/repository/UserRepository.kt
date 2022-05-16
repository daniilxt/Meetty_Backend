package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {
    fun getById(id: Long): UserEntity?
}