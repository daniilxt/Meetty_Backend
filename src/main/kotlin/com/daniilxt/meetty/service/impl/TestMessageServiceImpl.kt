package com.daniilxt.meetty.service.impl

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class TestMessageServiceImpl(
    val template: SimpMessagingTemplate
) {
    fun sendMessage(payload: String) {
        template.convertAndSend("/topic/chat", payload)
    }
}