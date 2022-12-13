package com.queckly.app.controller.schema


import com.expediagroup.graphql.server.operations.Query as GqlQuery
import com.queckly.app.controller.QuecklySchema
import org.springframework.stereotype.Component

@Suppress("unused")
class Echo : QuecklySchema {
    @Component
class Query : GqlQuery {
        fun hello(): Greetings = Greetings("Hello Kotlin!")
        data class Greetings(val message: String)
    }
}