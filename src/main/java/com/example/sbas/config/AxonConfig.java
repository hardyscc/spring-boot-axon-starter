package com.example.sbas.config;

import com.example.sbas.aggregates.AccountAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    public EventSourcingRepository<AccountAggregate> repositoryForAccountAggregate(EventStore eventStore) {
        return EventSourcingRepository.builder(AccountAggregate.class).eventStore(eventStore).build();
    }
}
