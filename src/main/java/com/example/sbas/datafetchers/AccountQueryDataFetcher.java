package com.example.sbas.datafetchers;

import com.example.sbas.entities.Account;
import com.example.sbas.services.queries.AccountQueryService;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountQueryDataFetcher {

    private final AccountQueryService accountQueryService;

    public DataFetcher<Account> account() {
        return dataFetchingEnvironment -> {
            String accountNumber = dataFetchingEnvironment.getArgument("accountNumber");
            return this.accountQueryService.getAccount(accountNumber);
        };
    }

//    public DataFetcher listEventsForAccount() {
//        return dataFetchingEnvironment -> {
//            String accountNumber = dataFetchingEnvironment.getArgument("accountNumber");
//            return this.accountQueryService.listEventsForAccount(accountNumber);
//        };
//    }
}
