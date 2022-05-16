package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.UserEntity
import java.time.LocalDate

data class UserPersonalInfoRequest(
    val firstName: String,
    val lastName: String,
    val birthDay: LocalDate,
    val phoneNumber: String,
    val sex: String
)

fun UserPersonalInfoRequest.toUserEntity(email: String) =
    UserEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        email = email,
        phone = this.phoneNumber,
        sex = this.sex,
        birthDay = this.birthDay,
    )
