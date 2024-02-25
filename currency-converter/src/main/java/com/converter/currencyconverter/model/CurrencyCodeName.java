package com.converter.currencyconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class CurrencyCodeName {

    private String currencyCode;

    private String currencyName;

}
