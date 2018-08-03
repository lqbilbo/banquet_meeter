package com.bm.kotlin.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.jmx.export.annotation.ManagedResource
import java.util.*
import javax.persistence.*

@ManagedResource
@Entity
@NamedQuery(name = "Person.findByTheFirstName", query = "from Person p where p.firstName = ?1")
class Person (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        @Column(unique = true)
        var firstName: String?,
        var lastName: String?,
        var gender: String?,
        var age: Int?,
        var label: String?,
        var avatar: String?,
        @CreatedDate
        var gmtCreated: Date?,
        @LastModifiedDate
        var gmtModified: Date?
) {
    override fun toString(): String {
        return "Person(id=$id, firstName='$firstName', lastName='$lastName', gender='$gender', age=$age," +
                "label=$label, avatar=$avatar, gmtCreated=$gmtCreated, $gmtModified=$gmtModified)"
    }

    fun getAge(): Int {
        return 11
    }

    fun getFirst1Name(): String {
        return "Benjamin"
    }
}