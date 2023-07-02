package com.practice.app.service;

import com.practice.app.feign.IcurrenciesFeignClient;
import com.practice.app.model.RateEntityModel;
import com.practice.app.model.RateModel;
import com.practice.app.repository.IRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrenciesService {

    private final IcurrenciesFeignClient currenciesFeignClient;
    private final IRateRepository rateRepository;

    @Value(value = "${exchange-rates.app-id}")
    private String appId;

    public RateModel getRates(String currencies) {
        RateModel rateModel = currenciesFeignClient.getRates(this.appId, currencies);
        try {
            for (String currency : currencies.split(","))
                rateRepository.save(RateEntityModel.builder()
                        .currencyFrom("USD")
                        .currencyTo(currency)
                        .exchangeValue(rateModel.getRates().get(currency))
                        .build());

        } catch (Exception ignored) {
            return null;
        }
            return rateModel;
        }
    }
