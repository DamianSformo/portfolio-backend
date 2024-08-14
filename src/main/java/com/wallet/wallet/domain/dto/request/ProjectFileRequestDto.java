package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class ProjectFileRequestDto {

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

    @Schema(type = "long", example = "1")
    private Long projectId;

}
