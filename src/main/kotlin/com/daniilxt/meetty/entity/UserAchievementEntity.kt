package com.daniilxt.meetty.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user_achievement")
class UserAchievementEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val description: String,
    val date: LocalDate,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
    val title: String
)