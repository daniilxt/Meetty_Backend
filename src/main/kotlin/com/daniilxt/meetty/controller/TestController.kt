package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.ChatSocketMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/chat")
class TestController(
    private val simpleMessageTemplate: SimpMessagingTemplate
) {
    @MessageMapping("/sock")
    fun chatSocket(res: ChatSocketMessage) {
        println(res)
        sendMessageToUsers(res) //отправим сообщения другим пользователям
    }

    private fun sendMessageToUsers(message: ChatSocketMessage) {
        if (message.receiver != null) {
            //если сообщение отправляется в приватный чат
            simpleMessageTemplate.convertAndSendToUser(message.receiver!!, ".topic/chat", message)
        } else {
            //если сообщение отправляется в общий чат
            simpleMessageTemplate.convertAndSend("/topic/chat", message)
        }
    }
}