package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.DialogDto
import com.daniilxt.meetty.service.DialogMessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialogs")
class DialogController(
    private val dialogMessageService: DialogMessageService
) {
    @GetMapping
    fun getAll(): List<DialogDto> = dialogMessageService.getAll()
}