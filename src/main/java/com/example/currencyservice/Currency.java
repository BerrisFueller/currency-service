package com.example.currencyservice;

public enum Currency {
    USD(1),
    EUR(0.95),
    YEN(129.21),
    PHP(52.44),
    ISK(131.85);

    private double rate;

    private Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
