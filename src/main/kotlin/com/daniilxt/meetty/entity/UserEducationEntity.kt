package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "user_education")
class UserEducationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "university_id")
    val university: UniversityEntity,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
)