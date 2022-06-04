package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.MessageDto
import com.daniilxt.meetty.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/message")
class MessageController(
    private val messageService: MessageService
) {
    @PostMapping()
    fun sendMessage(@RequestBody messageDto: MessageDto): Long {
        return messageService.sendMessage(messageDto)
    }
}