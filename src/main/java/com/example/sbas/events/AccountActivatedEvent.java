package com.example.sbas.events;

import com.example.sbas.aggregates.Status;
import lombok.ToString;

@ToString
public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}