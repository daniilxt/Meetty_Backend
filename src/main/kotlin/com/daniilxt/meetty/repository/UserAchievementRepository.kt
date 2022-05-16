package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UserAchievementEntity
import org.springframework.data.repository.CrudRepository

interface UserAchievementRepository : CrudRepository<UserAchievementEntity, Long> {
}