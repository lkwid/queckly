package com.queckly.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public")
class PublicController {
    @GetMapping
    fun greetings(): String = "Welcome to Queckly. Building in progress."
}