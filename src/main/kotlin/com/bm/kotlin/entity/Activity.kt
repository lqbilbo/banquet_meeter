package com.bm.kotlin.entity

import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Pageable
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Activity (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var placeId: Long,
        var sponsorId: Long,
        var activityStatus: Int,
        var publishTime: Date,
        var startTime: Date,
        var endTime: Date,
        @LastModifiedDate
        var utime: Date
) {
    override fun toString(): String {
        return "Activity(id=$id, placeId=$placeId, sponsorId=$sponsorId, activityStatus=$activityStatus, publishTime=$publishTime, startTime=$startTime, endTime=$endTime, utime=$utime)"
    }
}