package com.wallet.wallet.domain.dto.request;

import com.wallet.wallet.domain.enums.EIncome;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeUpdateDto {

    @Schema(hidden = true)
    private Long id;

    @Schema(type = "double", example = "100.5")
    private Double amount;

    @Schema(type = "string", example = "")
    private String description;

    private EIncome type;

    @Schema(type = "localdate", example = "2022-11-30")
    private LocalDate date;

    @Schema(type = "boolean", example = "true")
    private Boolean isIncluded;
}
