package com.example.sbas.services.queries;

import com.example.sbas.entities.Account;

import java.util.List;

public interface AccountQueryService {

    List<Object> listEventsForAccount(String accountNumber);

    Account getAccount(String accountNumber);
}
