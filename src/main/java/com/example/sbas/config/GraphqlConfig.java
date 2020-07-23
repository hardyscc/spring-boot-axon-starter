package com.example.sbas.config;

import com.example.sbas.resolvers.AccountCommandResolver;
import com.example.sbas.resolvers.AccountQueryResolver;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GraphqlConfig {

    private final AccountQueryResolver accountQueryResolver;
    private final AccountCommandResolver accountCommandResolver;

    @Bean
    GraphQLSchema schema() {
        return new GraphQLSchemaGenerator()
                .withBasePackages("com.example.sbas")
                .withOperationsFromSingleton(this.accountQueryResolver)
                .withOperationsFromSingleton(this.accountCommandResolver)
                .generate();
    }
}
