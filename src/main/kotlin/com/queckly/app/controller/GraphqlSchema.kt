package com.queckly.app.controller


import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class GraphqlSchema : Query {
    fun hello(): String = "Hello Kotlin!"
}