package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.UniversityEntity
import com.daniilxt.meetty.entity.UserEducationEntity
import com.daniilxt.meetty.entity.UserEntity
import java.io.File

data class UserEducationInfoRequest(
    val instituteId: Long,
    val photos: List<File> = emptyList()
) {
}

fun UserEducationInfoRequest.toUserEducationEntity(university: UniversityEntity, user: UserEntity) =
    UserEducationEntity(
        university = university,
        user = user
    )