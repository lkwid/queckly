package com.queckly.app.system.mq


import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Declarables
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MqConfigUsers {
    @Bean
    fun exchange(): DirectExchange = DirectExchange(MqEnum.X_USERS.mqName)

    @Bean
    fun queueRegisterUser(): Queue = buildQueue(MqEnum.Q_USERS_REGISTER.mqName)

    @Bean
    fun bindings(exchange: DirectExchange, vararg queues: Queue): Declarables {
        return Declarables(
            queues.map { queue -> BindingBuilder.bind(queue).to(exchange).withQueueName() }
        )
    }

    private fun buildQueue(name: String) = Queue(
        name, true, false, false,
        mapOf("x-queue-type" to "quorum")
    )
}
