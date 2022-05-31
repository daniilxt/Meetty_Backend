package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.EducationInstitutionDto
import javax.persistence.*

@Entity
@Table(name = "university")
class UniversityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @OneToOne
    @JoinColumn(name = "location_info_id")
    val locationInfo: LocationInfoEntity,
    val logo: String,
)

fun UniversityEntity.toEducationInstitutionDto() = EducationInstitutionDto(
    id = this.id,
    name = this.name,
    location = this.locationInfo.toLocationInfoDto(),
    logoUri = this.logo
)