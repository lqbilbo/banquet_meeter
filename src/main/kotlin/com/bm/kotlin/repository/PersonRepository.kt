package com.bm.kotlin.repository

import com.bm.kotlin.entity.Person
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface PersonRepository : CrudRepository<Person, Long> {
    fun findByLastName(lastName: String): List<Person>?

    fun findByTheFirstName(firstName: String): Person?

    /*@Query("update person set last_name = ?1 where id = ?2")
    @Modifying(clearAutomatically = true)
    @Transactional
    fun updateLastName(lastName: String, id: Int): Void*/
}