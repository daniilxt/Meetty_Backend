package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.ReactionEntity
import org.springframework.data.repository.CrudRepository

interface ReactionsRepository : CrudRepository<ReactionEntity, Long>