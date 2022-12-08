package com.queckly.app

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@AutoConfiguration
class QuecklyAppApplication

fun main(args: Array<String>) {
	runApplication<QuecklyAppApplication>(*args)
}
