package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;

@Data
public class PrizeResponseDto {

    private Long id;

    private Integer year;

    private String titleEs;

    private String titleEn;

    private Integer orderIndex;

    private ERecordStatus recordStatus;

}
