package com.practice.app.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@Table(name = "rate_entity_model", schema = "public")
public class RateEntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rate_id_generator")
    @SequenceGenerator(name = "rate_id_generator", schema = "public", sequenceName = "rate_entity_model_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "currency_from")
    private String currencyFrom;
    @Column(name = "currency_to")
    private String currencyTo;
    @Column(name = "exchange_value")
    private BigDecimal exchangeValue;
}
