package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.DialogDto
import com.daniilxt.meetty.dto.MessageDto

interface DialogMessageService {
    fun getAll(): List<DialogDto>
    fun getDialogsByUserId(userId: Long): List<DialogDto>
    fun getDialogsByUserEmail(userEmail: String): List<DialogDto>
    fun getDialogIdOrCreate(userId: Long, messageDto: MessageDto): Long
}
