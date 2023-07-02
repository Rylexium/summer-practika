package com.practice.app.controller;

import com.practice.app.model.RateModel;
import com.practice.app.service.CurrenciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rate/from/USD/to")
public class CurrenciesController {

    private final CurrenciesService service;

    @GetMapping("{currency}")
    public ResponseEntity<RateModel> getRates(@PathVariable String currency){
        return ResponseEntity.ok(service.getRates(currency));
    }
}
