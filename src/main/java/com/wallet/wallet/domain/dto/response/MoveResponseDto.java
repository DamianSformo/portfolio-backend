package com.wallet.wallet.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MoveResponseDto {

    private Double amount;

    private String categoryName;

    private String categoryIcon;

    private String categoryColorCode;

    private String currencyCode;

    private LocalDate date;

    private String type;

    private Boolean isIncluded;

}
