package com.queckly.app.controller.dto

class UserDtoBuilder {
    private var id: String? = null
    private var firstName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var password: String? = null

    fun id(id: String) = apply { this.id = id }
    fun firstName(firstName: String? = null) = apply { this.firstName = firstName }
    fun lastName(lastName: String? = null) = apply { this.lastName = lastName }
    fun email(email: String) = apply { this.email = email }
    fun password(password: String) = apply { this.password = password }

    fun build() =
        UserDto(id, firstName, lastName, email ?: throw IllegalStateException("email is required"), password)
}
