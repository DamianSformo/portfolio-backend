package com.wallet.wallet.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
@Data
public class Currency {

    @Id
    @SequenceGenerator(name = "currencySequence",sequenceName = "currencySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currencySequence")
    private Long id;

    private String codeCurrency;

    private Double valueDollar;

    private String symbol;

}
