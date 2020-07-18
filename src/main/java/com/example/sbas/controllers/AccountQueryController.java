package com.example.sbas.controllers;

import com.example.sbas.entities.Account;
import com.example.sbas.services.queries.AccountQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank-accounts")
@AllArgsConstructor
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable(value = "accountNumber") String accountNumber) {
        return accountQueryService.getAccount(accountNumber);
    }

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber) {
        return accountQueryService.listEventsForAccount(accountNumber);
    }
}
