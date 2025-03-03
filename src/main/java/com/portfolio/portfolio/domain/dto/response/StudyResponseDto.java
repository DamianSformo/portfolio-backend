package com.portfolio.portfolio.domain.dto.response;

import lombok.Data;

@Data
public class StudyResponseDto {

    private Long id;

    private Integer startYear;

    private Integer endYear;

    private String descriptionEs;

    private String descriptionEn;

    private String site;

}
