package com.daniilxt.meetty.dto

import com.daniilxt.meetty.entity.CoordinatesEntity

data class CoordinatesDto(
    val latitude: Float,
    val longitude: Float
)

fun CoordinatesDto.toCoordinatesEntity() = CoordinatesEntity(
    latitude = this.latitude,
    longitude = this.longitude
)