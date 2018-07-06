package com.bm.kotlin.repository

import com.bm.kotlin.entity.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository: CrudRepository<Order, Long> {
}