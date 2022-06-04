package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.DialogDto
import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.service.DialogMessageService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/dialogs")
class DialogController(
    private val dialogMessageService: DialogMessageService
) {
    @GetMapping
    fun getUserDialogs(): List<DialogDto> {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        return dialogMessageService.getDialogsByUserEmail(authenticatedUserEmail)
    }

    @PostMapping("/user_id={user_id}")
    fun createDialog(@PathVariable("user_id") userId: Long, @RequestBody messageDto: MessageDto): Long =
        dialogMessageService.getDialogIdOrCreate(userId, messageDto)
}