package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExhibitionResponseDtoLang {

    @Schema(type = "long", example = "1")
    private Long id;

    @Schema(type = "double", example = "100.5")
    private EExhibitionType type;

    @Schema(type = "string", example = "")
    private Integer year;

    @Schema(type = "long", example = "1")
    private String title;

    @Schema(type = "boolean", example = "true")
    private String text;

    @Schema(type = "boolean", example = "true")
    private Integer orderIndex;
}
