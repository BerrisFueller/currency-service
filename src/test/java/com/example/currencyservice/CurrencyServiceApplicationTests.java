package com.example.currencyservice;

import com.example.currencyservice.consumer.dto.CurrencyRequest;
import com.example.currencyservice.consumer.dto.CurrencyResponse;
import com.example.currencyservice.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CurrencyServiceApplicationTests {

    private final CurrencyService currencyService = new CurrencyService();

    @Test
    public void inEUR() {

        CurrencyResponse currencyResponse = currencyService.
                updatePriceToSelectedCurrency(BigDecimal.valueOf(100), Currency.EUR);

        assertEquals(BigDecimal.valueOf(100)
                .multiply(BigDecimal.valueOf(1.2))
                .setScale(2, RoundingMode.CEILING), currencyResponse.getPrice());
    }

    @Test
    public void inPhp() {


        CurrencyResponse currencyResponse = currencyService
                .updatePriceToSelectedCurrency(BigDecimal.valueOf(100), Currency.PHP);

        assertEquals(BigDecimal.valueOf(100).
                multiply(BigDecimal.valueOf(52.44)).
                setScale(2, RoundingMode.CEILING), currencyResponse.getPrice());
    }

    @Test
    public void inIsk() {


        CurrencyResponse currencyResponse = currencyService.
                updatePriceToSelectedCurrency(BigDecimal.valueOf(100), Currency.ISK);

        assertEquals(BigDecimal.valueOf(100)
                .multiply(BigDecimal.valueOf(138.85))
                .setScale(2, RoundingMode.CEILING), currencyResponse.getPrice());
    }

    @Test
    public void inYen() {


        CurrencyResponse currencyResponse = currencyService.
                updatePriceToSelectedCurrency(BigDecimal.valueOf(100), Currency.YEN);

        assertEquals(BigDecimal.valueOf(100)
                .multiply(BigDecimal.valueOf(130.5))
                .setScale(2, RoundingMode.CEILING), currencyResponse.getPrice());
    }

    @Test
    public void inUSD() {


        CurrencyResponse currencyResponse = currencyService
                .updatePriceToSelectedCurrency(BigDecimal.valueOf(120), Currency.USD);

        assertEquals(BigDecimal.valueOf(1)
                .multiply(BigDecimal.valueOf(120))
                .setScale(2, RoundingMode.CEILING), currencyResponse.getPrice());
    }

}
