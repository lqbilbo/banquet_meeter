package com.easy.kotlin

import com.bm.kotlin.Product
import com.bm.kotlin.util.JSONUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class kotlinUsingJavaTest {

    @Test
    fun testArrayList() {
        val source = listOf(1,2,3,4,5)
        val list = ArrayList<Int>()
        for (item in source) {
            list.add(item)
        }
        for (i in 0..source.size-1) {
            list[i] = source[i]
        }
    }

    @Test
    fun testGetterSetter() {
        val product = Product()
        product.name = "财务系统"
        product.category = "金融财务类"
        product.gmtCreated = Date()
        product.gmtModified = Date()
        println(JSONUtils.toJsonString(product))
        Assert.assertTrue(product.getName()=="财务系统")
        Assert.assertTrue(product.name=="财务系统")
    }

    @Test
    fun testCallingJavaNullSafe() {
        val product = Product()
        product.category = "金融财务类"
        product.gmtCreated = Date()
        product.gmtModified = Date()
        println(JSONUtils.toJsonString(product))

        val name = product.name
        println("product name is ${name}")

        val eqName = name == "财务系统"
        println(eqName)
        name?.substring(1)
    }

    @Test
    fun testSAMFunctionalInterface() {
        val runnable = Runnable { println("执行测试") }
        val thread = Thread(runnable)
        thread.start()

        val text = """
             |First Line
             |Second Line
             |Third Line
             """.trimMargin()
    }

    @Test
    fun testFindByFirstName() {
    }
}