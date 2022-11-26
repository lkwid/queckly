package com.queckly.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuecklyAppApplication

fun main(args: Array<String>) {
	runApplication<QuecklyAppApplication>(*args)
}
