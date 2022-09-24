package com.example.currencyservice.service;


import com.example.currencyservice.Currency;
import com.example.currencyservice.consumer.dto.CurrencyResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyService {

    public CurrencyResponse updatePriceToSelectedCurrency(BigDecimal price, Currency currency) {
        BigDecimal rawPrice = requestedCurrency(currency).multiply(price);
        BigDecimal roundedPrice = rawPrice.setScale(2, RoundingMode.CEILING);
        return new CurrencyResponse().setPrice(roundedPrice);
    }

    public BigDecimal requestedCurrency(Currency currency) {

        switch (currency) {
            case USD -> {
                return new BigDecimal("1");
            }
            case EUR -> {
                return new BigDecimal("1.2");
            }
            case YEN -> {
                return new BigDecimal("130.5");
            }
            case PHP -> {
                return new BigDecimal("52.44");
            }
            case ISK -> {
                return new BigDecimal("138.85");
            }
            default -> throw new IllegalStateException("UNKOWN CURRENCY" + currency);
        }
    }
}
