package com.example.sbas.resolvers;

import com.example.sbas.services.queries.AccountQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountQueryResolver {

    private final AccountQueryService accountQueryService;

//    @GraphQLQuery
//    public Account getAccount(@GraphQLArgument(name = "accountNumber") String accountNumber) {
//        return this.accountQueryService.getAccount(accountNumber);
//    }
//
//    @GraphQLQuery
//    public List<Object> listEventsForAccount(@GraphQLArgument(name = "accountNumber") String accountNumber) {
//        return this.accountQueryService.listEventsForAccount(accountNumber);
//    }
}
