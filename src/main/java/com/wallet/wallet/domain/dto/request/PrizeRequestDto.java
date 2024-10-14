package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrizeRequestDto {

    @Schema(description = "Año", example = "2023")
    private Integer year;

    @Schema(description = "Título en español", example = "Residente en R.A.R.O. Madrid")
    private String titleEs;

    @Schema(description = "Título en inglés", example = "Resident in R.A.R.O. Madrid")
    private String titleEn;

    @Schema(description = "Orden de todos los elementos", format = "number", example = "1")
    private Integer orderIndex;

}
