package com.portfolio.portfolio.domain.dto.request;

import com.portfolio.portfolio.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ExhibitionRequestDto {

    @Schema(type = "string", example = "GROUP", description = "Tipo de exhibición (enum: GROUP, INDIVIDUAL)")
    @NotNull(message = "El tipo de exhibición es obligatorio")
    private EExhibitionType type;

    @Schema(type = "integer", example = "2024", description = "Año en que se realizó la exhibición")
    @NotNull(message = "El año es obligatorio")
    @Min(value = 1900, message = "El año no puede ser anterior a 1900")
    @Max(value = 2100, message = "El año no puede ser posterior a 2100")
    private Integer year;

    @Schema(type = "string", example = "Título en español", description = "Título de la exhibición en español")
    @NotBlank(message = "El título en español es obligatorio")
    @Size(max = 255, message = "El título en español no puede exceder los 255 caracteres")
    private String titleEs;

    @Schema(type = "string", example = "Title in English", description = "Título de la exhibición en inglés")
    @NotBlank(message = "El título en inglés es obligatorio")
    @Size(max = 255, message = "El título en inglés no puede exceder los 255 caracteres")
    private String titleEn;

    @Schema(type = "string", example = "Descripción en español", description = "Texto adicional de la exhibición en español")
    @NotBlank(message = "La descripción en español es obligatoria")
    private String textEs;

    @Schema(type = "string", example = "Description in English", description = "Texto adicional de la exhibición en inglés")
    @NotBlank(message = "La descripción en inglés es obligatoria")
    private String textEn;
}
