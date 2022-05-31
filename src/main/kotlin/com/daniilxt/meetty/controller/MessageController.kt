package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dialog")
class MessageController(
    private val messageService: MessageService
) {
    @GetMapping("/{id}/messages")
    fun getAll(@PathVariable("id") dialogId: Long): List<MessageDto> = messageService.getAll(dialogId)
}