package com.example.sbas.services.queries;

import com.example.sbas.entities.Account;
import com.example.sbas.entities.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final EventStore eventStore;

    private final AccountRepository accountRepository;

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map(Message::getPayload).collect(Collectors.toList());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.findById(accountNumber).orElseThrow();
    }
}
