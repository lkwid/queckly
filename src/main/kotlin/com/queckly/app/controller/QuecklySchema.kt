package com.queckly.app.controller

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import org.springframework.stereotype.Component
@Component
@GraphQLDescription("""
    Queckly GraphQL schema. Consists of the following endpoints:
     - Echo -- a simple ping to the graphql
     - Users -- users management
""")
class QuecklySchema