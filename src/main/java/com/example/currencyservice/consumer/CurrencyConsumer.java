package com.example.currencyservice.consumer;

import com.example.currencyservice.Currency;
import com.example.currencyservice.consumer.dto.CurrencyRequest;
import com.example.currencyservice.consumer.dto.CurrencyResponse;
import com.example.currencyservice.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class CurrencyConsumer {

    @Autowired
    CurrencyService currencyService;

    int receivedPrice;
    Currency wantedCurrency;

    @RabbitListener(queues = "${queue.currency}")
    public CurrencyResponse ConversionOfCurrency(CurrencyRequest currencyRequest){


    try {
        receivedPrice = currencyRequest.getPrice();
        wantedCurrency = currencyRequest.getWantedCurrency();
    }catch (IllegalArgumentException e){
        log.error("Illegal REQUEST!" + e);
    }
       return currencyService.updatePriceToSelectedCurrency(receivedPrice,wantedCurrency);
    }

}
