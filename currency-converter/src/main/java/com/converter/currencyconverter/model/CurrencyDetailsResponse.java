package com.converter.currencyconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CurrencyDetailsResponse<T extends  Number> {

    private String targetCurrency;
    private T exchangeRate;
}
