package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.ProfessionalInterestEntity
import com.daniilxt.meetty.entity.UserEntity
import com.daniilxt.meetty.entity.UserProfessionalInterestEntity

data class ProfessionalInterestRequest(
    val id: Long,
    val interestName: String
)

fun ProfessionalInterestRequest.toUserProfessionalInterestEntity(userEntity: UserEntity) =
    UserProfessionalInterestEntity(
        interests = ProfessionalInterestEntity(id = this.id, nameRu = this.interestName),
        user = userEntity
    )