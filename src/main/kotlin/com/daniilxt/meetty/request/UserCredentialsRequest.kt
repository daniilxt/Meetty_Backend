package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.UserDetailEntity
import com.daniilxt.meetty.entity.UserEntity
import extensions.toEncryptedPassword

data class UserCredentialsRequest(
    val email: String,
    val password: String
)

fun UserCredentialsRequest.toUserDetailEntity(user: UserEntity) =
    UserDetailEntity(
        login = this.email,
        userPassword = this.password.toEncryptedPassword(),
        user = user
    )