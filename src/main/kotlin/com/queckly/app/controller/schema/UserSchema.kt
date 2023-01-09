package com.queckly.app.controller.schema

import com.queckly.app.controller.QuecklySchema
import com.queckly.app.controller.dto.UserDto
import com.queckly.app.controller.dto.UserDtoBuilder
import com.queckly.app.service.UserService
import org.springframework.stereotype.Component
import com.expediagroup.graphql.server.operations.Query as GqlQuery
import com.expediagroup.graphql.server.operations.Mutation as GqlMutation

@Suppress("unused")
class UserSchema(
) : QuecklySchema {
    @Component
    class Query(
        private val service: UserService
    ) : GqlQuery {
        suspend fun listUsers(): List<UserDto> = service.getUsers()

        suspend fun testError(message: String): String {
            service.test(message)
            return "Message sent"
        }
    }

    @Component
    class Mutation(
        private val service: UserService
    ) : GqlMutation {
        suspend fun registerUser(
            firstName: String?,
            lastName: String?,
            email: String,
            password: String
        ): String {
            val userDTO = UserDtoBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build()
            val id: String = service.save(userDTO)
            return "Registration OK (ID = $id)"
        }
        suspend fun deleteByEmail(email: String): String = service.deleteByEmail(email)
    }

}
