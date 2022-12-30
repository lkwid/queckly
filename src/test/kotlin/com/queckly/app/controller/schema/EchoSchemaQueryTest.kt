package com.queckly.app.controller.schema

import com.queckly.app.TestProfiles
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile

@Profile(TestProfiles.UNIT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EchoSchemaQueryTest {

    @Autowired
    lateinit var query: EchoSchema.Query

    @Test
    fun `Should be an exact match`() {
        assertTrue(query.hello().message == "Hello Kotlin!")
    }

}