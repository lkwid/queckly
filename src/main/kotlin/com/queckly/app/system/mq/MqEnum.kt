package com.queckly.app.system.mq

@Suppress("unused")
enum class MqEnum(val exchange: String, val dlExchange: String, val queue: String, val dlQueue: String ) {
    // Queues
    MQ_USER_REGISTER(
        "x.user",
        "x.user.dlx",
        "q.user.register",
        "q.user.register.dlq"
    ),
}