package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExhibitionResponseDto {

    @Schema(type = "long", example = "1")
    private Long id;

    @Schema(type = "double", example = "100.5")
    private EExhibitionType type;

    @Schema(type = "string", example = "")
    private Integer year;

    @Schema(type = "long", example = "1")
    private String titleEs;

    @Schema(type = "long", example = "1")
    private String titleEn;

    @Schema(type = "boolean", example = "true")
    private String textEs;

    @Schema(type = "boolean", example = "true")
    private String textEn;

    @Schema(type = "boolean", example = "true")
    private Integer orderIndex;
}
