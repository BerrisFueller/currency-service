package com.example.currencyservice.consumer;

import com.example.currencyservice.Currency;
import com.example.currencyservice.consumer.dto.CurrencyRequest;
import com.example.currencyservice.service.CurrencyService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;


@Slf4j
public class CurrencyConsumer {

    @Autowired
    CurrencyService currencyService;

    BigDecimal receivedPrice;
    Currency wantedCurrency;

    @RabbitListener(queues = "${queue.currency}")
    public String ConversionOfCurrency(Message message) {

        CurrencyRequest currencyRequest = new Gson()
                .fromJson(new String(message.getBody(), StandardCharsets.UTF_8), CurrencyRequest.class);

        try {
            receivedPrice = currencyRequest.getPrice();
            wantedCurrency = currencyRequest.getWantedCurrency();
        } catch (IllegalArgumentException e) {
            log.error("Illegal REQUEST!" + e);
        }
        return new Gson().toJson(currencyService.updatePriceToSelectedCurrency(receivedPrice, wantedCurrency));
    }

}
