package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;

import java.util.List;

@Data
public class ProjectResponseDto {

    private Long id;

    private String titleEs;

    private String titleEn;

    private String descriptionEs;

    private String descriptionEn;

    private String textEs;

    private String textEn;

    private String site;

    private String techniqueEs;

    private String techniqueEn;

    private Integer year;

    private Integer orderIndex;

    private List<ProjectFileResponseDto> projectFiles;

    private ERecordStatus recordStatus;
}
