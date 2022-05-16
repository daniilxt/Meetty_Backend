package com.daniilxt.meetty.request

import java.time.LocalDate

data class UserAchievementRequest(
    val title: String,
    val achievementDescription: String,
    val date: LocalDate
)