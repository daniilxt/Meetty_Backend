package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "user_reactions")
class UserReactionsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToMany
    @JoinColumn(name = "reaction_id")
    val reaction: List<ReactionEntity>,
    val reactionUserId: Long,
    val messageId: Long
)