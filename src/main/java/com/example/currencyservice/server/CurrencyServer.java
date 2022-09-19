package com.example.currencyservice.server;

import com.example.currencyservice.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class CurrencyServer {

    @Autowired
    CurrencyService currencyService;

    public double ConversionOfCurrency(CurrencyRequest currencyRequest){

    int receivedPrice = -1 ;
    Currency wantedCurrency = Currency.NULL;

    try {
        receivedPrice = currencyRequest.getPrice();
        wantedCurrency = currencyRequest.getWantedCurrency();
    }catch (IllegalArgumentException e){
        log.error("Illegal REQUEST!" + e);
    }
       return currencyService.updatePriceToSelectedCurrency(receivedPrice,wantedCurrency);
    }

}
