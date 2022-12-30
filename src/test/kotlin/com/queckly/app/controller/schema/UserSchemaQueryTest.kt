package com.queckly.app.controller.schema

import com.queckly.app.TestProfiles
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile

@Profile(TestProfiles.UNIT)
@ExperimentalCoroutinesApi
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserSchemaQueryTest {

    @Autowired
    lateinit var query: UserSchema.Query

    @Test
    fun `listUsers is not empty`() = runTest {
        assertTrue(query.listUsers().isNotEmpty())
    }
}
