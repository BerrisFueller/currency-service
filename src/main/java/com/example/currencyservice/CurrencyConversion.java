package com.example.currencyservice;

public class CurrencyConversion {
    Currency from;
    Currency to;

    public CurrencyConversion(Currency from, Currency to) {
        this.from = from;
        this.to = to;
    }

    public double conversion(double price) {
        double toUsd = price / from.getRate();
        double round = Math.round(100 * toUsd * to.getRate());
        return round / 100;
    }

}
