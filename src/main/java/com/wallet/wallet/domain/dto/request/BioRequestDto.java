package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioRequestDto {

    @Schema(description = "Nombre", example = "Marcía Ruíz Bochides")
    private String name;

    @Schema(description = "Url de la foto", example = "...")
    private String urlPhoto;

    @Schema(description = "Texto alternativo de la foto en Español", example = "Foto de Marcia Ruis Bochides")
    private String textPhotoEs;

    @Schema(description = "Texto alternativo de la foto en Inglés", example = "Foto de Marcia Ruis Bochides")
    private String textPhotoEn;

    @Schema(description = "Bio en Español", example = "Foto de Marcia Ruis Bochides")
    private String bioEs;

    @Schema(description = "Bio en Inglés", example = "Foto de Marcia Ruis Bochides")
    private String bioEn;

    @Schema(description = "Statement en Español", example = "Foto de Marcia Ruis Bochides")
    private String statementEs;

    @Schema(description = "Statement en Inglés", example = "Foto de Marcia Ruis Bochides")
    private String statementEn;
}
