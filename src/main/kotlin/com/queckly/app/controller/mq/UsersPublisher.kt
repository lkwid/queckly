package com.queckly.app.controller.mq

import com.queckly.app.controller.dto.UserDto
import com.queckly.app.system.mq.MqEnum.MQ_USER_REGISTER
import mu.KLogging
import org.apache.logging.log4j.message.SimpleMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class UsersPublisher(private val template: RabbitTemplate) : KLogging() {
    suspend fun register(userDto: UserDto) {
        template.convertAndSend(MQ_USER_REGISTER.queue, userDto)
        logger.info { "Registration OK (ID = ${userDto.id})" }
    }

    suspend fun test(message: String) {
        template.convertAndSend("q.user.test", message)
//        template.convertSendAndReceive("q.user.test", message)
//        logger.info { "Called back message: $callback" }
    }

    @RabbitListener(queues = ["q.user.test.dlq"])
    fun dlExchangeUser(message: SimpleMessage) {
//        return message.toString()
        logger.info { "User Exchange returned error: $message" }
    }
}
