package com.bm.kotlin.repository

import com.bm.kotlin.entity.Activity
import com.bm.kotlin.model.ConditionParams
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

interface ActivityRepository: PagingAndSortingRepository<Activity, Long> {

    //通过PageRequest赋值
    /*fun findByConditions(conditions: ConditionParams, pageable: Pageable) : Activity?

    fun findByConditionsSortable(conditions: ConditionParams, sort: Sort) : List<Activity>

    fun findByConditionsPageable(conditions: ConditionParams, pageable: Pageable) : List<Activity>*/
}