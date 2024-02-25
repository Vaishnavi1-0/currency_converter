package com.converter.currencyconverter.service;

import com.converter.currencyconverter.enums.CurrencyCode;
import com.converter.currencyconverter.enums.CurrencyUrl;
import com.converter.currencyconverter.model.CurrencyDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;


@Slf4j
@Service
public class CurrencyConverterImpl implements CurrencyConverter{


    private RestTemplate restTemplate;

    private InrCurrencyConverter inrCurrencyConverter;

    private JpyCurrencyConverter jpyCurrencyConverter;

    private EurCurrencyConverter eurCurrencyConverter;

    private UsdCurrencyConverter usdCurrencyConverter;
    @Autowired
    public CurrencyConverterImpl(RestTemplate restTemplate, InrCurrencyConverter inrCurrencyConverter,
                                 JpyCurrencyConverter jpyCurrencyConverter,
                                 EurCurrencyConverter eurCurrencyConverter,
                                 UsdCurrencyConverter usdCurrencyConverter){
        this.restTemplate =restTemplate;
        this.inrCurrencyConverter = inrCurrencyConverter;
        this.jpyCurrencyConverter =jpyCurrencyConverter;
        this.usdCurrencyConverter = usdCurrencyConverter;
        this.eurCurrencyConverter = eurCurrencyConverter;
    }

    @Override
    public CurrencyDetailsResponse convertSourceCurrency(String sourceCurrency, Double sourceAmount, String targetCurrency) throws Exception {
        String url = CurrencyUrl.CURRENCY_URL.getValue().replace(CurrencyUrl.SOURCE_CURRENCY.getValue(), sourceCurrency);
        ResponseEntity<String> data = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(gethttpHeaders()), String.class);
        JSONObject allData = new JSONObject(data.getBody());
        JSONObject exchangeRates = allData.getJSONObject(sourceCurrency);
        Double exchangeRateForTargetCurrency = Double.valueOf(allData.getJSONObject(sourceCurrency).get(targetCurrency).toString()) ;
        String targetAmount = getCurrencyFormatter(targetCurrency).convertCurrency(sourceAmount*exchangeRateForTargetCurrency);
        return new CurrencyDetailsResponse(targetAmount,exchangeRateForTargetCurrency);

    }
    private HttpHeaders gethttpHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private CurrencyFormatter getCurrencyFormatter(String targetCurrency) throws Exception{
        if (targetCurrency.equals(CurrencyCode.inr.toString())) {
            return inrCurrencyConverter;
        }else if(targetCurrency.equals(CurrencyCode.jpy.toString())){
            return jpyCurrencyConverter;
        }else if(targetCurrency.equals(CurrencyCode.usd.toString())){
            return usdCurrencyConverter;
        }else if(targetCurrency.equals(CurrencyCode.eur.toString())){
            return eurCurrencyConverter;
    }else{
            return null;
        }
    }
}
