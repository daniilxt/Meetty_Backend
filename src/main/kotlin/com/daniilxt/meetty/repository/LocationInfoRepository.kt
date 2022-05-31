package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.LocationInfoEntity
import org.springframework.data.repository.CrudRepository

interface LocationInfoRepository : CrudRepository<LocationInfoEntity, Long>