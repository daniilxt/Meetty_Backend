package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserReactionsEntity
import org.springframework.data.repository.CrudRepository

interface UserReactionsRepository : CrudRepository<UserReactionsEntity, Long>