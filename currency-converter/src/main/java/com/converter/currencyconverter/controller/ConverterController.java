package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.CurrencyConverterApplication;
import com.converter.currencyconverter.model.CurrencyDetailsResponse;
import com.converter.currencyconverter.service.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/currency/converter")
public class ConverterController {

    @Autowired
    private CurrencyConverter currencyConverter;
    @GetMapping
    public CurrencyDetailsResponse checkResponse(String sourceCurrency, Double sourceAmount, String targetCurrency) throws Exception {
        return currencyConverter.convertSourceCurrency(sourceCurrency, sourceAmount, targetCurrency);
    }


}
