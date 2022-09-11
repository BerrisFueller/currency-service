package com.example.currencyservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "currency")
public class CurrencyConversionController {

    @GetMapping(path = "{price}/from/{from}/to/{to}")
    public double convertCurrency(@PathVariable double price, @PathVariable Currency from, @PathVariable Currency to) {

        CurrencyConversion converter = new CurrencyConversion(from, to);

        return converter.conversion(price);

    }

}