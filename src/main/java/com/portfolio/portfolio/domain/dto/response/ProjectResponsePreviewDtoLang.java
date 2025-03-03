package com.portfolio.portfolio.domain.dto.response;

import lombok.Data;

@Data
public class ProjectResponsePreviewDtoLang {

    private Long id;

    private String title;

    private Integer year;

    private Integer orderIndex;

    private ProjectFileResponseDtoLang projectFile;
}
