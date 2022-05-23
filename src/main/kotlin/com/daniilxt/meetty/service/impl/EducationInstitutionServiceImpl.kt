package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.EducationInstitutionDto
import com.daniilxt.meetty.dto.toCoordinatesEntity
import com.daniilxt.meetty.entity.LocationInfoEntity
import com.daniilxt.meetty.entity.UniversityEntity
import com.daniilxt.meetty.entity.toEducationInstitutionDto
import com.daniilxt.meetty.repository.CityRepository
import com.daniilxt.meetty.repository.CoordinatesRepository
import com.daniilxt.meetty.repository.LocationInfoRepository
import com.daniilxt.meetty.repository.UniversityRepository
import com.daniilxt.meetty.service.EducationInstitutionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EducationInstitutionServiceImpl(
    private val universityRepository: UniversityRepository,
    private val cityRepository: CityRepository,
    private val coordinatesRepository: CoordinatesRepository,
    private val locationInfoRepository: LocationInfoRepository
) : EducationInstitutionService {
    override fun getAll(): List<EducationInstitutionDto> {
        return universityRepository.findAll().map {
            it.toEducationInstitutionDto()
        }
    }

    @Transactional
    override fun save(data: EducationInstitutionDto): Long {
        val city = cityRepository.findByName(data.location.city.name)
        val coordinates = coordinatesRepository.save(data.location.coordinates.toCoordinatesEntity())
        val location = locationInfoRepository.save(
            LocationInfoEntity(
                city = city,
                address = data.location.address,
                coordinates = coordinates
            )
        )
        val universityEntity = UniversityEntity(
            name = data.name,
            locationInfo = location,
            logo = data.logoUri
        )
        return universityRepository.save(universityEntity).id
    }

    override fun deleteById(id: Long) {
        universityRepository.deleteById(id)
    }
}