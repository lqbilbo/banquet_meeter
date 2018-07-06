package com.bm.kotlin.entity

import java.util.*
import javax.persistence.*

@Entity
class Account (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(unique = true)
    val userName: String,
    val password: String,
    val registerTime: Date,
    val lastLoginTime: Date
) {
    override fun toString(): String {
        return "Account(id=$id, userName='$userName', password='$password', registerTime=$registerTime, $lastLoginTime=$lastLoginTime)"
    }

}