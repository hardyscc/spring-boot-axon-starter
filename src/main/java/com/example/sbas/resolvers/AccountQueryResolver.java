package com.example.sbas.resolvers;

import com.example.sbas.entities.Account;
import com.example.sbas.services.queries.AccountQueryService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@GraphQLApi
@AllArgsConstructor
public class AccountQueryResolver {

    private final AccountQueryService accountQueryService;

    @GraphQLQuery
    public Account getAccount(@GraphQLArgument(name = "accountNumber") String accountNumber) {
        return this.accountQueryService.getAccount(accountNumber);
    }

    @GraphQLQuery
    public List<Object> listEventsForAccount(@GraphQLArgument(name = "accountNumber") String accountNumber) {
        return this.accountQueryService.listEventsForAccount(accountNumber);
    }
}
