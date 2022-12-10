package com.queckly.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/")
class SystemController {
    @GetMapping
    fun sayHello(): Mono<Greetings> = Mono.just(Greetings("Hello, Authenticated!"))
    data class Greetings(val message: String)
}
