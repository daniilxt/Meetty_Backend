package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "reaction")
class ReactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val reactionEmoji: String
)