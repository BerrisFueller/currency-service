package com.example.currencyservice.consumer.dto;

import com.example.currencyservice.Currency;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyRequest {

    private Currency wantedCurrency;
    private BigDecimal price;

}
