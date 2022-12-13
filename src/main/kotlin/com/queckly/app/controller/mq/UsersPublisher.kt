package com.queckly.app.controller.mq

import com.queckly.app.controller.dto.UserDTO
import com.queckly.app.system.mq.MqEnum
import mu.KLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class UsersPublisher(private val template: RabbitTemplate) : KLogging() {
    fun register(userDTO: UserDTO) {
        template.convertAndSend(MqEnum.Q_USERS_REGISTER.mqName, userDTO)
        logger.info { "User registered successfully" }
    }
}
