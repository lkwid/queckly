package com.queckly.app.system.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun webFilterChain(
        http: ServerHttpSecurity,
//        resolver: ReactiveClientRegistrationRepository,
    ): SecurityWebFilterChain? {
        return http
            .csrf()
//                .disable()
                .csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeExchange()
                .pathMatchers("/public").permitAll()
            .anyExchange()
                .authenticated()
            .and()
                .oauth2Login()
            .and()
                .oauth2ResourceServer()
                    .jwt()
            .and().and()
            .build()
    }

}