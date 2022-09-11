package com.example.currencyservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionTest {

    @Test
    void conversionUSDtoUSD() {
        CurrencyConversion usdToUsd = new CurrencyConversion(Currency.USD, Currency.USD);
        assertEquals(1412, usdToUsd.conversion(1412));
    }

    @Test
    void conversionUSDtoEUR() {
        CurrencyConversion usdToEur = new CurrencyConversion(Currency.USD, Currency.EUR);
        assertEquals(332.49, usdToEur.conversion(349.99));
    }

    @Test
    void conversionUSDtoYEN() {
        CurrencyConversion usdToYen = new CurrencyConversion(Currency.USD, Currency.YEN);
        assertEquals(1408.39, usdToYen.conversion(10.90));
    }

    @Test
    void conversionUSDtoPHP() {
        CurrencyConversion usdToPhp = new CurrencyConversion(Currency.USD, Currency.PHP);
        assertEquals(1046.18, usdToPhp.conversion(19.95));
    }

    @Test
    void conversionUSDtoISK() {
        CurrencyConversion usdToIsk = new CurrencyConversion(Currency.USD, Currency.ISK);
        assertEquals(35992.41, usdToIsk.conversion(272.98));
    }

    @Test
    void conversionPHPtoUSD() {
        CurrencyConversion phpToUsd = new CurrencyConversion(Currency.PHP, Currency.USD);
        assertEquals(3.83, phpToUsd.conversion(200.99));
    }

    @Test
    void conversionYENtoISK() {
        CurrencyConversion yenToIsk = new CurrencyConversion(Currency.YEN, Currency.ISK);
        assertEquals(5102.16, yenToIsk.conversion(5000));
    }

    @Test
    void conversionEURtoISK() {
        CurrencyConversion eurToIsk = new CurrencyConversion(Currency.EUR, Currency.ISK);
        assertEquals(1138.07, eurToIsk.conversion(8.20));
    }

    @Test
    void conversionISKtoPHP() {
        CurrencyConversion iskToPhp = new CurrencyConversion(Currency.ISK, Currency.PHP);
        assertEquals(159.07, iskToPhp.conversion(399.95));
    }

    @Test
    void conversionYENtoYEN() {
        CurrencyConversion yenToYen = new CurrencyConversion(Currency.YEN, Currency.YEN);
        assertEquals(44.44, yenToYen.conversion(44.44));
    }

    @Test
    void conversionZero() {
        CurrencyConversion iskToEur = new CurrencyConversion(Currency.ISK, Currency.EUR);
        assertEquals(0, iskToEur.conversion(0));
    }

}