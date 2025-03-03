package com.portfolio.portfolio.domain.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ExhibitionCompleteResponseDtoLang {

    private List<ExhibitionResponseDtoLang> exhibitionGroup;

    private List<ExhibitionResponseDtoLang> exhibitionIndividual;

    private List<PrizeResponseDtoLang> prizes;

}
