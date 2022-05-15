package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserDetailEntity
import org.springframework.data.repository.CrudRepository

interface UserDetailsRepository : CrudRepository<UserDetailEntity, Long> {
    fun findUserByLogin(userName: String): UserDetailEntity?
}