package com.queckly.app.controller.schema

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsersQueryTest {

    @Autowired
    lateinit var query: Users.Query

    @Test
    fun `listUsers is not empty`() {
        assertTrue(query.listUsers().isNotEmpty())
    }

}