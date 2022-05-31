package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.CityEntity
import org.springframework.data.repository.CrudRepository

interface CityRepository : CrudRepository<CityEntity, Long> {
    fun findByName(name: String): CityEntity
}