package com.queckly.app.controller.schema

import com.expediagroup.graphql.server.operations.Query as GqlQuery
import com.okta.sdk.client.Client
import com.queckly.app.controller.QuecklySchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Suppress("unused")
class Users : QuecklySchema {
    @Component
    class Query @Autowired constructor(
        private val api: Client
    ) : GqlQuery {
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
    data class UserType(val id: String, val firstName: String, val lastName: String, val email: String)

}
