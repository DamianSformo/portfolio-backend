package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioRequestDtoEs {

    @Schema(type = "string", example = "test")
    private String name;

    @Schema(type = "string", example = "test")
    private String urlPhoto;

    @Schema(type = "string", example = "test")
    private String textPhotoEs;

    @Schema(type = "string", example = "test")
    private String bioEs;

    @Schema(type = "string", example = "test")
    private String bioShortEs;

    @Schema(type = "string", example = "test")
    private String statementEs;
}
