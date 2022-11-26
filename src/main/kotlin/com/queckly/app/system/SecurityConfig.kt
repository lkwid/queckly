package com.queckly.app.system

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun webFilterChain(http: ServerHttpSecurity, reactiveClientRegistrationRepository: ReactiveClientRegistrationRepository): SecurityWebFilterChain? {
//        return http.csrf().csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()).and()
        return http.csrf().disable()
            .authorizeExchange()
                .pathMatchers("/public").permitAll()
            .anyExchange()
                .authenticated()
            .and()
            .oauth2Login{auth -> auth.authorizationRequestResolver(pkceResolver(reactiveClientRegistrationRepository))}
            .build()
    }

    @Bean
    fun pkceResolver(repo: ReactiveClientRegistrationRepository): ServerOAuth2AuthorizationRequestResolver {
        val resolver = DefaultServerOAuth2AuthorizationRequestResolver(repo)
        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce())
        return resolver
    }

}