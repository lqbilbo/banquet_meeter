package com.bm.kotlin.service

import com.bm.kotlin.entity.Person
import com.bm.kotlin.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService : PersonRepository {

    @Autowired
    val personRepository: PersonRepository? = null

    override fun findByTheFirstName(firstName: String): Person? {
        return personRepository?.findByTheFirstName(firstName)
    }

    override fun <S : Person?> save(entity: S): S? {
        return personRepository?.save(entity)
    }

    override fun findAll(): MutableIterable<Person>? {
        return personRepository?.findAll()
    }

    override fun deleteById(id: Long?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(entities: MutableIterable<Person>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Person?> saveAll(entities: MutableIterable<S>?): MutableIterable<S>? {
        return personRepository?.saveAll(entities)
    }

    override fun count(): Long {
        return personRepository?.count()!!
    }

    override fun findAllById(ids: MutableIterable<Long>?): MutableIterable<Person>? {
        return personRepository?.findAllById(ids)
    }

    override fun existsById(id: Long?): Boolean {
        return personRepository?.existsById(id)!!
    }

    override fun findById(id: Long?): Optional<Person>? {
        return personRepository?.findById(id)
    }

    override fun delete(entity: Person?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByLastName(lastName: String): List<Person>? {
        return personRepository?.findByLastName(lastName)
    }
}