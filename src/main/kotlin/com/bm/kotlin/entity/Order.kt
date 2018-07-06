package com.bm.kotlin.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
class Order(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
//        @OneToOne
        val activityId: Long,
        val attenderId: Long,
        val orderStatus: Int,
        @CreatedDate
        val ctime: Date,
        @LastModifiedDate
        val utime: Date
) {
    override fun toString(): String {
        return "Order(id=$id, activityId=$activityId, attenderId=$attenderId, orderStatus=$orderStatus, ctime=$ctime, utime=$utime)"
    }
}