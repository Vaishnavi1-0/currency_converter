package com.converter.currencyconverter.enums;

public enum CurrencyUrl {

    CURRENCY_URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/<source_currency>.json"),
    SOURCE_CURRENCY("<source_currency>");

    private String sourceCurrency;

    CurrencyUrl(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getValue() {
        return sourceCurrency;
    }
}
