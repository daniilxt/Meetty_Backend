package com.daniilxt.meetty.request

import com.daniilxt.meetty.entity.UserAchievementEntity
import com.daniilxt.meetty.entity.UserEntity
import java.time.LocalDate

data class UserAchievementRequest(
    val title: String,
    val achievementDescription: String,
    val date: LocalDate
)

fun UserAchievementRequest.toUserAchievementEntity(user: UserEntity) = UserAchievementEntity(
    description = achievementDescription,
    title = title,
    date = date,
    user = user
)