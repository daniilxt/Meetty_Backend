package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.MessageEntity
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<MessageEntity, Long> {
    fun findTopByDialogIdOrderByIdDesc(id: Long): MessageEntity
}