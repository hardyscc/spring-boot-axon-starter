package com.example.sbas.entities.updaters;

import com.example.sbas.aggregates.AccountAggregate;
import com.example.sbas.entities.Account;
import com.example.sbas.entities.repositories.AccountRepository;
import com.example.sbas.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AccountAggregateUpdater {

    private final AccountRepository accountRepository;

    private final EventSourcingRepository<AccountAggregate> accountAggregateRepository;

    @EventSourcingHandler
    void on(BaseEvent<String> event) {
        log.info("{}", event);
        this.persistAccount(this.buildQueryAccount(this.getAccountFromEvent(event)));
    }

    private AccountAggregate getAccountFromEvent(BaseEvent<String> event) {
        return this.accountAggregateRepository.load(event.id).getWrappedAggregate().getAggregateRoot();
    }

    private Account findExistingOrCreateQueryAccount(String id) {
        return this.accountRepository.findById(id).isPresent() ? this.accountRepository.findById(id).get() : new Account();
    }

    private Account buildQueryAccount(AccountAggregate accountAggregate) {
        Account account = this.findExistingOrCreateQueryAccount(accountAggregate.getId());

        account.setId(accountAggregate.getId());
        account.setAccountBalance(accountAggregate.getAccountBalance());
        account.setCurrency(accountAggregate.getCurrency());
        account.setStatus(accountAggregate.getStatus());

        return account;
    }

    private void persistAccount(Account account) {
        this.accountRepository.save(account);
    }
}
