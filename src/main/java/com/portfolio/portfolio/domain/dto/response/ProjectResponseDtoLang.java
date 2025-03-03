package com.portfolio.portfolio.domain.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResponseDtoLang {

    private Long id;

    private String title;

    private String description;

    private String text;

    private Integer year;

    private String site;

    private String technique;

    private Integer orderIndex;

    private List<ProjectFileResponseDtoLang> projectFiles;
}
