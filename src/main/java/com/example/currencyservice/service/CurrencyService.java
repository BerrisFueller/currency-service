package com.example.currencyservice.service;


import com.example.currencyservice.Currency;
import com.example.currencyservice.consumer.dto.CurrencyResponse;

public class CurrencyService {

    public CurrencyResponse updatePriceToSelectedCurrency(int price, Currency currency){
        return  new CurrencyResponse().setCurrencyResponse(requestedCurrency(currency) * price);

    }

    public double requestedCurrency(Currency currency) {

        switch (currency){
            case USD -> {
                return 1;
            }
            case EUR -> {
                return 1.2;
            }
            case YEN -> {
                return 130.5;
            }
            case PHP -> {
                return 52.44;
            }
            case ISK -> {
                return 138.85;
            }
            default ->    throw new IllegalStateException("UNKOWN CURRENCY" + currency);
        }
    }
}
