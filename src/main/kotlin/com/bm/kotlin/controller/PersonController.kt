package com.bm.kotlin.controller

import com.bm.kotlin.entity.Person
import com.bm.kotlin.service.PersonService
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

@Controller
class PersonController {

    @Autowired
    val personService: PersonService? = null

    val logger: Logger? = null

    @GetMapping(value = "/")
    @ResponseBody
    fun sayHello(): Any {
        return "Hello World"
    }

    @GetMapping(value = "/person")
    @ResponseBody
    fun hello(@RequestParam(value = "lastName") lastName: String): Any {
        val persons = personService?.findByLastName(lastName)
        /*val map = HashMap<Any, Any>()
        map.put("person", persons!!)*/
        val list = ArrayList<Any>()
        list.addAll(persons!!)
        return list
    }

    @GetMapping(value = "/person/1")
    @ResponseBody
    fun person1(@RequestParam(value = "firstName") firstName: String): Any {
        val person = personService?.findByTheFirstName(firstName)
        val list = ArrayList<Person?>()
        list.add(person)
        return list
    }

    @GetMapping(value = "/login")
    @ResponseBody
    fun login(@RequestParam(value = "age", required = false) age: Int?,
              @RequestParam(value = "firstName", required = false) firstName: String?,
              @RequestParam(value = "gender", required = false) gender: String?,
              @RequestParam(value = "lastName", required = false) lastName: String?,
              @RequestParam(value = "label", required = false) label: String?,
              @RequestParam(value = "avatar", required = false) avatar: String?): Person? {

        val person = Person(null, firstName,lastName,gender,age,label,avatar,Date(),Date())
        return personService?.save(person)
    }

    @PostMapping(value = "upload")
    @ResponseBody
    fun upload(@RequestParam(value = "file") file: MultipartFile): String {
        if (!file.isEmpty) {
            try {
                val out = BufferedOutputStream(FileOutputStream(File(file.originalFilename)))
                out.write(file.bytes)
                //upload to mt cloud
                out.flush()
                out.close()
            } catch (e: IOException) {
                logger?.error("upload failed: " + e.message, e)
            }
            return "upload success"
        } else {
            return "upload failed, because file is empty"
        }
    }
}