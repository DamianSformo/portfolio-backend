package com.portfolio.portfolio.domain.dto.request;

import com.portfolio.portfolio.domain.enums.EProjectFileType;
import lombok.Data;

@Data
public class ProjectFileRequestDto {

    private EProjectFileType type;

    private String url;

    private String textEs;

    private String textEn;

    private Boolean isCover;

    private Integer orderIndex;

    private Long projectId;

}
