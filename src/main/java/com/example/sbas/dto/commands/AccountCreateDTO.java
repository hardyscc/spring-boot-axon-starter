package com.example.sbas.dto.commands;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateDTO {

    private double startingBalance;

    @Schema(example = "USD")
    private String currency;
}
