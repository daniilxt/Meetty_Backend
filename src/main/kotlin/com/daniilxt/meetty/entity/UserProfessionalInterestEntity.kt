package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "user_professional_interest")
class UserProfessionalInterestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "interest_id")
    val interests: ProfessionalInterestEntity,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
)