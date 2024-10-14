package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
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
