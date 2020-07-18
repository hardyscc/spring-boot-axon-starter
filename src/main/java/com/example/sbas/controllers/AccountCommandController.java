package com.example.sbas.controllers;

import com.example.sbas.dto.commands.AccountCreateDTO;
import com.example.sbas.dto.commands.MoneyCreditDTO;
import com.example.sbas.dto.commands.MoneyDebitDTO;
import com.example.sbas.services.commands.AccountCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-accounts")
@AllArgsConstructor
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    @PostMapping
    public CompletableFuture<String> createAccount(
            @RequestBody AccountCreateDTO accountCreateDTO) {
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(
            @PathVariable(value = "accountNumber") String accountNumber,
            @RequestBody MoneyCreditDTO moneyCreditDTO) {
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(
            @PathVariable(value = "accountNumber") String accountNumber,
            @RequestBody MoneyDebitDTO moneyDebitDTO) {
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
