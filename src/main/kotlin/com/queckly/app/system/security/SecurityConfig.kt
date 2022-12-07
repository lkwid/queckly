package com.queckly.app.system.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun webFilterChain(
        http: ServerHttpSecurity,
//        reactiveClientRegistrationRepository: ReactiveClientRegistrationRepository,
    ): SecurityWebFilterChain? {
        return http
            .csrf()
                .disable()
//                .csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
//            .and()
            .authorizeExchange()
                .pathMatchers("/public").permitAll()
            .anyExchange()
                .authenticated()
            .and()
                .oauth2Login()
            .and()
//            .oauth2Login{auth -> auth.authorizationRequestResolver(pkceResolver(reactiveClientRegistrationRepository))}
            .build()
    }

//    @Bean
//    fun pkceResolver(repo: ReactiveClientRegistrationRepository): ServerOAuth2AuthorizationRequestResolver {
//        val resolver = DefaultServerOAuth2AuthorizationRequestResolver(repo)
//        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce())
//        return resolver
//    }

}