package com.bm.kotlin.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.io.Serializable

@NoRepositoryBean
interface BaseRepository<T, ID : Serializable> : Repository<T, ID> {
    fun findAll(page: Pageable) : Iterable<T>
    fun <S : T> save(entity: S): S
    fun<S : T> save(entities: Iterable<S>) : S
}