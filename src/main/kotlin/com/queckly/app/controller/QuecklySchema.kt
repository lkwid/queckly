package com.queckly.app.controller

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import org.springframework.stereotype.Component
@Component
@GraphQLDescription("""
    Queckly GraphQL schema. Implemented by the following endpoints:
     - EchoSchema -- a simple ping to the graphql
     - UserSchema -- users management
""")
interface QuecklySchema