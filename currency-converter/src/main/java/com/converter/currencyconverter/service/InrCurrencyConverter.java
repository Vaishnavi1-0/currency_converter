package com.converter.currencyconverter.service;

import com.converter.currencyconverter.model.CurrencyDetailsResponse;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Service
public class InrCurrencyConverter implements  CurrencyFormatter {

    @Override
    public String convertCurrency(Double currencyValue) {
        Locale inrCurrency = new Locale("en","IN");
        Currency currency = Currency.getInstance(inrCurrency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(inrCurrency);
    return    numberFormat.format(currencyValue);

    }
}
