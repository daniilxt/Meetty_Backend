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
        sendMessageToUsers(res)
    }

    private fun sendMessageToUsers(message: ChatSocketMessage) {
/*        val usersId = "${message.sender.id + message.receiver.id}"
        val usersNames = (message.sender.lastName + message.receiver.lastName)
        val res = (usersId + usersNames).toCharArray().sorted().joinToString("").toByteArray()
        val connectionUniqueStr = Base64.getEncoder().encodeToString(res)
        println(connectionUniqueStr)*/
        //simpleMessageTemplate.convertAndSendToUser(message.receiver.id.toString(), "/topic/chat", message)
        simpleMessageTemplate.convertAndSend("/topic/chat", message)
    }
}