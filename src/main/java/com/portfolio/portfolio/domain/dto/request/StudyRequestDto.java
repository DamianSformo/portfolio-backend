package com.portfolio.portfolio.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudyRequestDto {

    @Schema(description = "Año de inicio", example = "2012")
    private Integer startYear;

    @Schema(description = "Año de Finalización", example = "2016")
    private Integer endYear;

    @Schema(description = "Descripción en español", example = "Descripción...")
    private String descriptionEs;

    @Schema(description = "Descripción en inglés", example = "Description...")
    private String descriptionEn;

    @Schema(description = "Lugar", example = "UBA")
    private String site;

}
