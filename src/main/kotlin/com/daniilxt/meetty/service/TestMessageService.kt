package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.DialogDto

interface TestMessageService {
    fun getAll(): List<DialogDto>
}
