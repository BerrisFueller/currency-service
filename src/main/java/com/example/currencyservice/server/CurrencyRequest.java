package com.example.currencyservice.server;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyRequest {

    private int price;
    private Currency wantedCurrency;

}
