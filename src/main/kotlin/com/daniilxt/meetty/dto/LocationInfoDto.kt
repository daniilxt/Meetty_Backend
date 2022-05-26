package com.daniilxt.meetty.dto

import com.daniilxt.meetty.entity.CityEntity
import com.daniilxt.meetty.entity.LocationInfoEntity

data class LocationInfoDto(
    val city: CityDto,
    val address: String,
    val coordinates: CoordinatesDto
)

fun LocationInfoDto.toLocationInfoEntity() =
    LocationInfoEntity(
        city = this.city.toCityEntity(),
        address = this.address,
        coordinates = this.coordinates.toCoordinatesEntity()
    )

private fun CityDto.toCityEntity() = CityEntity(
    name = this.name
)