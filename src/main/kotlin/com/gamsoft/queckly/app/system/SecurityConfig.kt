package com.gamsoft.queckly.app.system

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun webFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        http.csrf().disable().authorizeExchange()
            .pathMatchers("/public**")
            .permitAll()
            .anyExchange()
            .authenticated()
            .and()
            .cors()
            .and()
            .oauth2Login()
        return http.build()
    }
}