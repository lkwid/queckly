package com.queckly.app.service

import com.okta.sdk.client.Client
import com.okta.sdk.resource.user.UserBuilder
import com.queckly.app.controller.dto.UserDto
import com.queckly.app.controller.dto.UserDtoBuilder
import com.queckly.app.controller.mq.UsersPublisher
import org.springframework.stereotype.Service

@Service
class UserService(
    private val client: Client,
    private val publisher: UsersPublisher,
) {
    suspend fun getUsers(): List<UserDto> = client.listUsers()
        .stream().map { user ->
            UserDtoBuilder()
                .id(user.id)
                .firstName(user.profile.firstName)
                .lastName(user.profile.lastName)
                .email(user.profile.email)
                .build()
        }.toList()

    suspend fun save(userDTO: UserDto): String {
        userDTO.id = UserBuilder.instance()
            .setFirstName(userDTO.firstName)
            .setLastName(userDTO.lastName)
            .setEmail(userDTO.email)
            .setLogin(userDTO.email)
            .setPassword(userDTO.password?.toCharArray())
            .buildAndCreate(client).id
        publisher.register(userDTO)
        return userDTO.id!!
    }

    suspend fun deleteById(id: String): String {
        client.getUser(id).delete()
        return "OK"
    }

}
