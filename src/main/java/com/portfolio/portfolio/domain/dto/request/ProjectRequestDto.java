package com.portfolio.portfolio.domain.dto.request;
import lombok.Data;

@Data
public class ProjectRequestDto {

    private String titleEs;

    private String titleEn;

    private String descriptionEs;

    private String descriptionEn;

    private String textEs;

    private String textEn;

    private Integer year;

    private String site;

    private String techniqueEs;

    private String techniqueEn;

    private Integer orderIndex;
}
