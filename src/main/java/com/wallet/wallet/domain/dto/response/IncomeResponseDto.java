package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeResponseDto {

    private Long id;

    private Double amount;

    private String description;

    private String type;

    private String currencyCode;

    private LocalDate date;

    private Boolean isIncluded;

    private Boolean deleted;

}
