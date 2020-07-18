package com.example.sbas.events;

public class BaseEvent<T> {

    public final T id;

    BaseEvent(T id) {
        this.id = id;
    }
}