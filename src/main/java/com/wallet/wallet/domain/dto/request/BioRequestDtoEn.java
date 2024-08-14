package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioRequestDtoEn {

    @Schema(type = "string", example = "test")
    private String name;

    @Schema(type = "string", example = "test")
    private String urlPhoto;

    @Schema(type = "string", example = "test")
    private String textPhotoEn;

    @Schema(type = "string", example = "test")
    private String bioEn;

    @Schema(type = "string", example = "test")
    private String bioShortEn;

    @Schema(type = "string", example = "test")
    private String statementEn;
}
