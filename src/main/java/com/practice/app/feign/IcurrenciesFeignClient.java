package com.practice.app.feign;


import com.practice.app.model.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currencies-client", url = "https://openexchangerates.org/api")
public interface IcurrenciesFeignClient {
    @GetMapping(value = "/latest.json?app_id={appId}&symbols={currencies}")
    RateModel getRates(@PathVariable String appId, @PathVariable String currencies);
}

