package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "cities")
class CityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
)
