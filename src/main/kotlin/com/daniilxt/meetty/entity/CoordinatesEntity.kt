package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.CoordinatesDto
import javax.persistence.*

@Entity
@Table(name = "coordinates")
class CoordinatesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val latitude: Float,
    val longitude: Float
)

fun CoordinatesEntity.toCoordinatesDto() = CoordinatesDto(
    latitude = this.latitude,
    longitude = this.longitude
)