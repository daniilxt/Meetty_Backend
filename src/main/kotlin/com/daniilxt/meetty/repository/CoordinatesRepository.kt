package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.CoordinatesEntity
import org.springframework.data.repository.CrudRepository

interface CoordinatesRepository : CrudRepository<CoordinatesEntity, Long>