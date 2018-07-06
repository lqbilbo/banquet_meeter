package com.bm.kotlin

import com.bm.kotlin.entity.Person
import com.bm.kotlin.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init(repository: PersonService) = CommandLineRunner {
        /*val now = Date()
        repository.save(Person(null, "Jason", "Chen",
                "Male", 28, now, now))
        repository.save(Person(null, "Bluce", "Li",
                "Male", 32, now, now))
        repository.save(Person(null, "Corey", "Chen",
                "Female", 20, now, now))
*/
        for (person in repository.findAll()!!) {
            log.info(person.toString())
        }

        val customer = repository.findById(1L)
        log.info(customer.toString())
        for (chen in repository.findByLastName("Chen")!!) {
            log.info(chen.toString())
        }
        log.info(repository.findByLastName("Chen")!!.toString())
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}