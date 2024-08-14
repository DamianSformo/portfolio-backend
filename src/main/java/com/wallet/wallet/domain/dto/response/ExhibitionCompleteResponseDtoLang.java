package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ExhibitionCompleteResponseDtoLang {

    @Schema(type = "long", example = "1")
    private Long id;

    @Schema(type = "double", example = "100.5")
    private List<ExhibitionResponseDtoLang> exhibitionGroup;

    @Schema(type = "double", example = "100.5")
    private List<ExhibitionResponseDtoLang> exhibitionIndividual;

}
