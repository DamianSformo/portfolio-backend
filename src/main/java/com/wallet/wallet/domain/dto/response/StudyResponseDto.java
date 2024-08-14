package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudyResponseDto {

    @Schema(type = "long", example = "1")
    private Long id;

    @Schema(type = "double", example = "100.5")
    private Integer startYear;

    @Schema(type = "string", example = "")
    private Integer endYear;

    @Schema(type = "long", example = "1")
    private String descriptionEs;

    @Schema(type = "long", example = "1")
    private String descriptionEn;

    @Schema(type = "long", example = "1")
    private String site;

    @Schema(type = "boolean", example = "true")
    private Integer orderIndex;

}
