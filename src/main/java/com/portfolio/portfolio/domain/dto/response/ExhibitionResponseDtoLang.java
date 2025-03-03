package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.EExhibitionType;
import lombok.Data;

@Data
public class ExhibitionResponseDtoLang {

    private Long id;

    private EExhibitionType type;

    private Integer year;

    private String title;

    private String text;

}
