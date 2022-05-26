package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.CityDto
import com.daniilxt.meetty.dto.LocationInfoDto
import javax.persistence.*

@Entity
@Table(name = "location_info")
class LocationInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "city_id")
    val city: CityEntity,
    val address: String,
    @OneToOne
    @JoinColumn(name = "coordinates_id")
    val coordinates: CoordinatesEntity
)

fun LocationInfoEntity.toLocationInfoDto() = LocationInfoDto(
    city = this.city.toCityDto(),
    address = this.address,
    coordinates = this.coordinates.toCoordinatesDto()
)

fun CityEntity.toCityDto() = CityDto(
    id = this.id,
    name = this.name
)
