package com.example.sbas.resolvers;

import com.example.sbas.dto.commands.AccountCreateDTO;
import com.example.sbas.dto.commands.MoneyCreditDTO;
import com.example.sbas.dto.commands.MoneyDebitDTO;
import com.example.sbas.services.commands.AccountCommandService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
@GraphQLApi
@AllArgsConstructor
public class AccountCommandResolver {

    private final AccountCommandService accountCommandService;

    @GraphQLMutation
    public CompletableFuture<String> createAccount(
            @GraphQLArgument(name = "input") AccountCreateDTO accountCreateDTO) {
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @GraphQLMutation
    public CompletableFuture<String> creditMoneyToAccount(
            @GraphQLArgument(name = "accountNumber") String accountNumber,
            @GraphQLArgument(name = "input") MoneyCreditDTO moneyCreditDTO) {
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @GraphQLMutation
    public CompletableFuture<String> debitMoneyFromAccount(
            @GraphQLArgument(name = "accountNumber") String accountNumber,
            @GraphQLArgument(name = "input") MoneyDebitDTO moneyDebitDTO) {
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
