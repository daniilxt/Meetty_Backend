package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.DialogDto
import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.entity.*
import com.daniilxt.meetty.exception.AuthException
import com.daniilxt.meetty.repository.DialogMessageRepository
import com.daniilxt.meetty.repository.MessageRepository
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.service.DialogMessageService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DialogMessageServiceImpl(
    private val userRepository: UserRepository,
    private val dialogMessageRepository: DialogMessageRepository,
    private val messageRepository: MessageRepository
) : DialogMessageService {
    override fun getAll(): List<DialogDto> {
        return dialogMessageRepository.findAll().map {
            getDialogFromEntity(it)
        }
    }

    override fun getDialogsByUserEmail(userEmail: String): List<DialogDto> {
        val userDialogs: MutableList<DialogDto> = mutableListOf()
        dialogMessageRepository.findAll().forEach {
            if (it.firstUser.email == userEmail || it.secondUser.email == userEmail) {
                userDialogs.add(getDialogFromEntity(it))
            }
        }
        return userDialogs
    }

    override fun getDialogsByUserId(userId: Long): List<DialogDto> {
        val userDialogs: MutableList<DialogDto> = mutableListOf()
        dialogMessageRepository.findAll().forEach {
            if (it.firstUser.id == userId || it.secondUser.id == userId) {
                userDialogs.add(getDialogFromEntity(it))
            }
        }
        return userDialogs
    }

    @Transactional
    override fun getDialogIdOrCreate(userId: Long, messageDto: MessageDto): Long {
        var dialogId: Long = dialogMessageRepository.findDialogIdByTwoUsersIdCustom(
            userId, messageDto.sender.id
        ) ?: -1L
        val firstUser = userRepository.getById(messageDto.sender.id) ?: throw AuthException.InvalidUser()
        val secondUser = userRepository.getById(userId) ?: throw AuthException.InvalidUser()

        if (dialogId == -1L) {
            dialogId =
                dialogMessageRepository.save(DialogEntity(firstUser = firstUser, secondUser = secondUser)).id
        }
        val dialogEntity = dialogMessageRepository.findDialogEntityById(dialogId)
        messageRepository.save(messageDto.toMessageEntity(firstUser, dialogEntity))
        return dialogId
    }

    private fun getDialogFromEntity(it: DialogEntity): DialogDto {
        return DialogDto(
            id = it.id,
            lastMessage = messageRepository.findTopByDialogIdOrderByIdDesc(it.id).toMessageDto(),
            firstUser = it.firstUser.toUserDto(),
            secondUser = it.secondUser.toUserDto()
        )
    }
}

fun MessageDto.toMessageEntity(sender: UserEntity, dialogEntity: DialogEntity) = MessageEntity(
    date = dateTime.toLocalDate(),
    time = dateTime.toLocalTime(),
    content = content,
    sender = sender,
    dialog = dialogEntity
)