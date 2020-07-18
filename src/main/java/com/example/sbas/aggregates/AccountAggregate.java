package com.example.sbas.aggregates;

import com.example.sbas.commands.CreateAccountCommand;
import com.example.sbas.commands.CreditMoneyCommand;
import com.example.sbas.commands.DebitMoneyCommand;
import com.example.sbas.events.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
@Getter
@NoArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
    private String id;

    private double accountBalance;

    private String currency;

    private String status;

    @CommandHandler
    @Autowired(required = false)
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent) {
        id = accountCreatedEvent.id;
        accountBalance = accountCreatedEvent.accountBalance;
        currency = accountCreatedEvent.currency;
        status = String.valueOf(Status.CREATED);

        AggregateLifecycle.apply(new AccountActivatedEvent(id, Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent) {
        status = String.valueOf(accountActivatedEvent.status);
    }

    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand) {
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount, creditMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent) {
        if (accountBalance < 0 & (accountBalance + moneyCreditedEvent.creditAmount) >= 0)
            AggregateLifecycle.apply(new AccountActivatedEvent(id, Status.ACTIVATED));

        accountBalance += moneyCreditedEvent.creditAmount;
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand) {
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent) {
        if (accountBalance >= 0 & (accountBalance - moneyDebitedEvent.debitAmount) < 0)
            AggregateLifecycle.apply(new AccountHeldEvent(id, Status.HOLD));

        accountBalance -= moneyDebitedEvent.debitAmount;
    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent) {
        status = String.valueOf(accountHeldEvent.status);
    }
}