package com.queckly.app.controller.schema

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EchoQuery {

    @Autowired
    lateinit var query: Echo.Query

    @Test
    fun `Should be an exact match`() {
        assertTrue(query.hello().message == "Hello Kotlin!")
    }

}