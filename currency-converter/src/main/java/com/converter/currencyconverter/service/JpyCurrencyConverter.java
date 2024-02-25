package com.converter.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Service
public class JpyCurrencyConverter implements CurrencyFormatter{


    @Override
    public String convertCurrency(Double currencyValue) {
       NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        return numberFormat.format(currencyValue);

    }
}
