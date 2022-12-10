package com.queckly.app.controller.schema

import com.expediagroup.graphql.server.operations.Query
import com.okta.sdk.client.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

data class UserType(val id: String, val firstName: String, val lastName: String, val email: String)

@Component
@Suppress("unused")
class UsersQuery @Autowired constructor(
    private val api: Client
) : Query {
    fun listUsers(): List<UserType> = api.listUsers()
        .stream().map { user ->
            UserType(
                user.id,
                user.profile.firstName,
                user.profile.lastName,
                user.profile.email
            )
        }.toList()
}
