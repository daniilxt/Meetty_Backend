package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.DialogDto

interface DialogMessageService {
    fun getAll(): List<DialogDto>
}
