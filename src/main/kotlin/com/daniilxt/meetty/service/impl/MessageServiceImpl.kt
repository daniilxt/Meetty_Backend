package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.entity.toMessageDto
import com.daniilxt.meetty.repository.MessageRepository
import com.daniilxt.meetty.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    private val messageRepository: MessageRepository
) : MessageService {
    override fun getAll(dialogId: Long): List<MessageDto> {
        return messageRepository.findAll().filter { it.dialog.id == dialogId }.map {
            it.toMessageDto()
        }
    }

    override fun getLastMessage(dialogId: Long): MessageDto {
        return messageRepository.findTopByDialogIdOrderByIdDesc(dialogId).toMessageDto()
    }
}