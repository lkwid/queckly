package com.queckly.app.system.mq

import com.queckly.app.system.mq.MqEnum.MQ_USER_REGISTER
import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MqConfigUser {

    @Bean
    fun exchange() = DirectExchange(MQ_USER_REGISTER.exchange)

    @Bean
    fun dlExchange() = FanoutExchange(MQ_USER_REGISTER.dlExchange)

    @Bean
    fun queueRegisterUser() = buildQueue(MQ_USER_REGISTER.queue)

    @Bean
    fun dlQueueRegisterUser() = buildQueue(MQ_USER_REGISTER.dlQueue)

    @Bean
    fun queueTest(): Queue = buildQueue(
        "q.user.test",
        "x-dead-letter-exchange" to MQ_USER_REGISTER.dlExchange,
        "x-dead-letter-routing-key" to "q.user.test.dlq",
        )

    @Bean
    fun dlQueueTest() = buildQueue("q.user.test.dlq")

    @Bean
    fun bindings(): Declarables {
        return Declarables(
            // queue
            BindingBuilder.bind(queueRegisterUser()).to(exchange()).withQueueName(),
            BindingBuilder.bind(queueTest()).to(exchange()).withQueueName(),

            //dead letter
            BindingBuilder.bind(dlQueueRegisterUser()).to(dlExchange()),
            BindingBuilder.bind(dlQueueTest()).to(dlExchange())
        )
    }

    private fun buildQueue(name: String, vararg args: Pair<String, String>) = Queue(
        name, true, false, false,
        mapOf(*args, "x-queue-type" to "quorum")
    )
}
