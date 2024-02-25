package com.converter.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@Service
public class EurCurrencyConverter implements CurrencyFormatter{
    @Override
    public String convertCurrency(Double currencyValue) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        return numberFormat.format(currencyValue);

    }
}
