package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.DialogEntity
import com.daniilxt.meetty.entity.MessageEntity
import org.springframework.data.repository.CrudRepository

interface DialogMessageRepository : CrudRepository<DialogEntity, Long>