package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.DialogEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface DialogMessageRepository : CrudRepository<DialogEntity, Long> {
    @Query(
        value = "select d.id from dialogs as d where (d.first_user_id = :u1 and d.second_user_id = :u2) or (d.first_user_id = :u2 and d.second_user_id = :u1)",
        nativeQuery = true
    )
    fun findDialogIdByTwoUsersIdCustom(
        @Param("u1") u1: Long,
        @Param("u2") u2: Long
    ): Long?

    fun findDialogEntityById(dialogId: Long): DialogEntity
}