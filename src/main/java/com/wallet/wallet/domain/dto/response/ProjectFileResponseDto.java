package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProjectFileResponseDto {

    @Schema(type = "string", example = "100.5")
    private String type;

    @Schema(type = "string", example = "100.5")
    private String url;

    @Schema(type = "string", example = "100.5")
    private String textEs;

    @Schema(type = "string", example = "100.5")
    private String textEn;

    @Schema(type = "string", example = "100.5")
    private Integer orderIndex;

}
