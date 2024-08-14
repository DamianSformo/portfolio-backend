package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BioResponseDtoEs {

    @Schema(type = "long", example = "test")
    private Long id;

    @Schema(type = "string", example = "test")
    private String name;

    @Schema(type = "string", example = "test")
    private String urlPhoto;

    @Schema(type = "string", example = "test")
    private String textPhoto;

    @Schema(type = "string", example = "test")
    private String bio;

    @Schema(type = "string", example = "test")
    private String bioShort;

    @Schema(type = "string", example = "test")
    private String statement;

}
