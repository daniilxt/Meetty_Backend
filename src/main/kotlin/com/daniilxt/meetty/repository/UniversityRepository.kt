package com.daniilxt.meetty.repository

import com.daniilxt.meetty.entity.UniversityEntity
import org.springframework.data.repository.CrudRepository

interface UniversityRepository : CrudRepository<UniversityEntity, Long>