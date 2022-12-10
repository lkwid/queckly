package com.queckly.app.controller.schema


import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class EchoQuery : Query {
    fun hello(): Greetings = Greetings("Hello Kotlin!")
    data class Greetings(val message: String)

}