package com.queckly.app.controller.mq

import com.queckly.app.controller.dto.UserDto
import com.queckly.app.system.mq.MqEnum
import mu.KLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class UsersPublisher(private val template: RabbitTemplate) : KLogging() {
    suspend fun register(userDto: UserDto) {
        template.convertAndSend(MqEnum.Q_USERS_REGISTER.mqName, userDto)
        logger.info { "Registration OK (ID = ${userDto.id})" }
    }
}
