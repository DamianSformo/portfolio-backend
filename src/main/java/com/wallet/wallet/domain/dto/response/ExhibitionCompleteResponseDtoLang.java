package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.EExhibitionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ExhibitionCompleteResponseDtoLang {

    private List<ExhibitionResponseDtoLang> exhibitionGroup;

    private List<ExhibitionResponseDtoLang> exhibitionIndividual;

    private List<PrizeResponseDtoLang> prizes;

}
