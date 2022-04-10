package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.DialogDto
import com.daniilxt.meetty.entity.toMessageDto
import com.daniilxt.meetty.entity.toUserDto
import com.daniilxt.meetty.repository.DialogMessageRepository
import com.daniilxt.meetty.repository.MessageRepository
import com.daniilxt.meetty.service.DialogMessageService
import org.springframework.stereotype.Service

@Service
class DialogMessageServiceImpl(
    private val dialogMessageRepository: DialogMessageRepository,
    private val messageRepository: MessageRepository
) : DialogMessageService {
    override fun getAll(): List<DialogDto> {
        return dialogMessageRepository.findAll().map {
            DialogDto(
                id = it.id,
                lastMessage = messageRepository.findTopByDialogIdOrderByIdDesc(it.id).toMessageDto(),
                firstUser = it.firstUser.toUserDto(),
                secondUser = it.secondUser.toUserDto()
            )
        }
    }
}