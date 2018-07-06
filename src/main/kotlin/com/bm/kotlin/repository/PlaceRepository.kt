package com.bm.kotlin.repository

import com.bm.kotlin.entity.Place
import org.springframework.data.repository.CrudRepository

interface PlaceRepository: CrudRepository<Place, Long> {
}