package com.daniilxt.meetty.entity

import javax.persistence.*

@Entity
@Table(name = "cities")
class CityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String
)