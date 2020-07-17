package com.example.sbas.dto.commands;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyDebitDTO {

    private double debitAmount;

    @Schema(example = "USD")
    private String currency;
}
