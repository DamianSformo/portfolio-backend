package com.portfolio.portfolio.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioRequestDto {

    @Schema(description = "Nombre", example = "Marcía Ruiz Bochides")
    private String name;

    @Schema(description = "Url de la foto", example = "https:/...")
    private String urlPhoto;

    @Schema(description = "Texto alternativo de la foto en Español", example = "Foto de Marcia Ruiz Bochides")
    private String textPhotoEs;

    @Schema(description = "Texto alternativo de la foto en Inglés", example = "Photo by Marcia Ruiz Bochides")
    private String textPhotoEn;

    @Schema(description = "Biografía en Español", example = "Estudió Arquitectura en la UBA...")
    private String bioEs;

    @Schema(description = "Biografía en Inglés", example = "He studied Architecture at UBA...")
    private String bioEn;

    @Schema(description = "Statement en Español", example = "...")
    private String statementEs;

    @Schema(description = "Statement en Inglés", example = "...")
    private String statementEn;
}
