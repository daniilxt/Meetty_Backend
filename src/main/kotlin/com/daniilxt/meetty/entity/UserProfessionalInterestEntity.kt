package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.ProfessionalInterestDto
import javax.persistence.*

@Entity
@Table(name = "user_professional_interest")
class UserProfessionalInterestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "interest_id")
    val interest: ProfessionalInterestEntity,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
)

// In future need edit this for edit interests in user profile
fun UserProfessionalInterestEntity.toProfessionalInterestDto() = ProfessionalInterestDto(
    id = interest.id,
    interest = interest.nameRu
)