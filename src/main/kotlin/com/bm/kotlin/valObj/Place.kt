package com.bm.kotlin.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Place(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,
        val poiId: Int,
        val poiName: String,
        val averagePrice: BigDecimal,
        val latitude: Double,
        val longitude: Double,
        @CreatedDate
        val ctime: Date,
        @LastModifiedDate
        val utime: Date
) {
    override fun toString(): String {
        return "Place(id=$id, poiId=$poiId, poiName='$poiName', averagePrice=$averagePrice, latitude=$latitude, longitude=$longitude, ctime=$ctime, utime=$utime)"
    }
}