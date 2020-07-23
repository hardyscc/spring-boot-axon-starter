package com.example.sbas.resolvers;

import com.example.sbas.services.commands.AccountCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountCommandResolver {

    private final AccountCommandService accountCommandService;

//    @GraphQLMutation
//    public CompletableFuture<String> createAccount(
//            @GraphQLArgument(name = "input") AccountCreateDTO accountCreateDTO) {
//        return this.accountCommandService.createAccount(accountCreateDTO);
//    }
//
//    @GraphQLMutation
//    public CompletableFuture<String> creditMoneyToAccount(
//            @GraphQLArgument(name = "accountNumber") String accountNumber,
//            @GraphQLArgument(name = "input") MoneyCreditDTO moneyCreditDTO) {
//        return this.accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
//    }
//
//    @GraphQLMutation
//    public CompletableFuture<String> debitMoneyFromAccount(
//            @GraphQLArgument(name = "accountNumber") String accountNumber,
//            @GraphQLArgument(name = "input") MoneyDebitDTO moneyDebitDTO) {
//        return this.accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
//    }
}
