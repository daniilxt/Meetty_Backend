package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.MessageDto

interface MessageService {
    fun getAll(dialogId: Long): List<MessageDto>
    fun getLastMessage(dialogId: Long): MessageDto
}
