package com.queckly.app.system.mq

@Suppress("unused")
enum class MqEnum(val mqName: String) {
    // Queues
    Q_USERS_REGISTER("q.users.register"),

    // Exchanges
    X_USERS("x.users")
}