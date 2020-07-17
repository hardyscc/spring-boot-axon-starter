package com.example.sbas.entities.updaters;

import com.example.sbas.aggregates.AccountAggregate;
import com.example.sbas.entities.Account;
import com.example.sbas.entities.repositories.AccountRepository;
import com.example.sbas.events.BaseEvent;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountAggregateUpdater {

    private final AccountRepository accountRepository;

    private final EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent<String> event){
        persistAccount(buildQueryAccount(getAccountFromEvent(event)));
    }

    private AccountAggregate getAccountFromEvent(BaseEvent<String> event){
        return accountAggregateEventSourcingRepository.load(event.id).getWrappedAggregate().getAggregateRoot();
    }

    private Account findExistingOrCreateQueryAccount(String id){
        return accountRepository.findById(id).isPresent() ? accountRepository.findById(id).get() : new Account();
    }

    private Account buildQueryAccount(AccountAggregate accountAggregate){
        Account account = findExistingOrCreateQueryAccount(accountAggregate.getId());

        account.setId(accountAggregate.getId());
        account.setAccountBalance(accountAggregate.getAccountBalance());
        account.setCurrency(accountAggregate.getCurrency());
        account.setStatus(accountAggregate.getStatus());

        return account;
    }

    private void persistAccount(Account account){
        accountRepository.save(account);
    }
}
