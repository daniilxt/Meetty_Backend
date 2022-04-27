package com.daniilxt.meetty.entity

import com.daniilxt.meetty.dto.LocationInfoDto
import javax.persistence.*

@Entity
@Table(name = "location_info")
class LocationInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @OneToOne
    @JoinColumn(name = "city_id")
    val city: CityEntity,
    val address: String,
    @OneToOne
    @JoinColumn(name = "coordinates_id")
    val coordinates: CoordinatesEntity
)

fun LocationInfoEntity.toLocationInfoDto() = LocationInfoDto(
    city = this.city.name,
    address = this.address,
    coordinates = this.coordinates.toCoordinatesDto()
)