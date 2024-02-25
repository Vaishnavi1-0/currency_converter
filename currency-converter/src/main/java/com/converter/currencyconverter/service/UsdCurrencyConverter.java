package com.converter.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@Service
public class UsdCurrencyConverter implements CurrencyFormatter{

    @Override
    public String convertCurrency(Double currencyValue) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(currencyValue);

    }
}
