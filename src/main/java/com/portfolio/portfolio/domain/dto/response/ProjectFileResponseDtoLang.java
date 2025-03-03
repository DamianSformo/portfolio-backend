package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.EProjectFileType;
import lombok.Data;

@Data
public class ProjectFileResponseDtoLang {

    private EProjectFileType type;

    private String url;

    private String text;

    private Boolean isCover;

    private Integer orderIndex;

}
