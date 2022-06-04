package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.UserEntity
import java.time.LocalDate

data class UserPersonalInfoRequest(
    val firstName: String,
    val lastName: String,
    val birthDay: LocalDate,
    val phoneNumber: String,
    val sex: String,
    val profilePicture: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserPersonalInfoRequest

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (birthDay != other.birthDay) return false
        if (phoneNumber != other.phoneNumber) return false
        if (sex != other.sex) return false
        if (!profilePicture.contentEquals(other.profilePicture)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + birthDay.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + sex.hashCode()
        result = 31 * result + profilePicture.contentHashCode()
        return result
    }
}

fun UserPersonalInfoRequest.toUserEntity(email: String) =
    UserEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        email = email,
        phone = this.phoneNumber,
        sex = this.sex,
        birthDay = this.birthDay,
        profilePicture = this.profilePicture
    )
