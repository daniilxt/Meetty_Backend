package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.ProfessionalInterestDto
import javax.persistence.*

@Entity
@Table(name = "professional_interests")
class ProfessionalInterestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name_ru")
    val nameRu: String
)

fun ProfessionalInterestEntity.toProfessionalInterestDto() =
    ProfessionalInterestDto(
        id = this.id,
        interest = this.nameRu
    )