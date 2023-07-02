package com.practice.app.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RateDto {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal exchangeValue;
}
