package com.example.sbas.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;

    BaseCommand(T id) {
        this.id = id;
    }
}