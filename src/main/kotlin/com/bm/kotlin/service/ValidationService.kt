package com.bm.kotlin.service

import com.bm.kotlin.entity.Account
import org.springframework.stereotype.Service

@Service
class ValidationService {

    /**
     * 验证证件有效性
     * @param certificate
     */
    fun validateCertificate(certificate: String): Boolean {

        /**
         * 调用Face++身份证与图像识别开放API
         * https://console.faceplusplus.com.cn/documents/5671702
         */
        return true
    }

    /**
     * 验证注册信息有效性
     */
    fun validateAccountInfo(account: Account): Boolean {

        return true
    }

    /**
     * 验证入参
     */
    fun validateParams(params: List<Any>): Boolean {

        return true
    }

}