package com.queckly.app.controller.schema

import com.okta.sdk.client.Client
import com.queckly.app.controller.QuecklySchema
import com.queckly.app.controller.dto.UserDTO
import com.queckly.app.controller.mq.UsersPublisher
import org.springframework.stereotype.Component
import com.expediagroup.graphql.server.operations.Query as GqlQuery

@Suppress("unused")
class Users : QuecklySchema {
    @Component
    class Query(
        private val api: Client,
        private val publisher: UsersPublisher
    ) : GqlQuery {
        suspend fun listUsers(): List<UserType> = api.listUsers()
            .stream().map { user ->
                UserType(
                    user.id,
                    user.profile.firstName,
                    user.profile.lastName,
                    user.profile.email
                )
            }.toList()

        suspend fun registerUser(): String {
            val userDTO = UserDTO(666, "Testus", "Testowiecki", "testus@queckly.com")
            publisher.register(userDTO)
            return "Registration OK"
        }

        data class UserType(val id: String, val firstName: String?, val lastName: String?, val email: String)
    }
}
