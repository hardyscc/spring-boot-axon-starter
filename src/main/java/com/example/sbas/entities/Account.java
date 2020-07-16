package com.example.sbas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {
    @Id
    private String id;

    private double accountBalance;

    private String currency;

    private String status;
}
