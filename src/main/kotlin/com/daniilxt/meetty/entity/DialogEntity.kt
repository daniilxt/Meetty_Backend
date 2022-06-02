package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "dialogs")
class DialogEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "first_user_id")
    val firstUser: UserEntity,
    @OneToOne
    @JoinColumn(name = "second_user_id")
    val secondUser: UserEntity,
)