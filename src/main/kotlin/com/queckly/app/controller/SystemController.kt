package com.queckly.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/system")
class SystemController {
    @GetMapping
    fun sayHello(): Mono<String> = Mono.just("Hello, Authenticated!")
}