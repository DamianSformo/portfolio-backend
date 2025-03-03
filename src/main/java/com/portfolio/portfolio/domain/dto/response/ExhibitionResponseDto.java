package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExhibitionResponseDto {

    @Schema(type = "long", example = "1", description = "Identificador único de la exhibición")
    private Long id;

    @Schema(type = "string", example = "GROUP", description = "Tipo de exhibición (enum: GROUP, INDIVIDUAL)")
    private EExhibitionType type;

    @Schema(type = "integer", example = "2024", description = "Año en que se realizó la exhibición")
    private Integer year;

    @Schema(type = "string", example = "Título en español", description = "Título de la exhibición en español")
    private String titleEs;

    @Schema(type = "string", example = "Title in English", description = "Título de la exhibición en inglés")
    private String titleEn;

    @Schema(type = "string", example = "Descripción en español", description = "Texto adicional de la exhibición en español")
    private String textEs;

    @Schema(type = "string", example = "Description in English", description = "Texto adicional de la exhibición en inglés")
    private String textEn;

}
