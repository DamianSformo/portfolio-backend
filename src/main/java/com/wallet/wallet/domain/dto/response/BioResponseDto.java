package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioResponseDto {

    @Schema(type = "long", example = "test")
    private Long id;

    @Schema(type = "string", example = "test")
    private String urlPhoto;

    @Schema(type = "string", example = "test")
    private String textPhotoEs;

    @Schema(type = "string", example = "test")
    private String textPhotoEn;

    @Schema(type = "string", example = "test")
    private String bioEs;

    @Schema(type = "string", example = "test")
    private String bioEn;
}
