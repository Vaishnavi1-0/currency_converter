package com.converter.currencyconverter.service;

import com.converter.currencyconverter.model.CurrencyDetailsResponse;

public interface CurrencyConverter {

    CurrencyDetailsResponse convertSourceCurrency(String sourceCurrency, Double sourceAmount, String targetCurrency) throws Exception;

}
