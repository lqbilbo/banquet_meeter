package com.bm.kotlin.repository

import com.bm.kotlin.entity.Account
import org.springframework.data.repository.CrudRepository

interface AccountRepository: CrudRepository<Account, Long> {
}