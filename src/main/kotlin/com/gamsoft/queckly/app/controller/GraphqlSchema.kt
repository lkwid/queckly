package com.gamsoft.queckly.app.controller

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin

@Suppress("unused")
@Component
@CrossOrigin(origins = ["http://localhost:8080"])
class GraphqlSchema : Query {
    fun hello(): String = "Hello Kotlin!"
}