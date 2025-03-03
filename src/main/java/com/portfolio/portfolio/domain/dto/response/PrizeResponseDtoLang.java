package com.portfolio.portfolio.domain.dto.response;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;

@Data
public class PrizeResponseDtoLang {

    private Long id;

    private Integer year;

    private String title;

    private Integer orderIndex;

    private ERecordStatus recordStatus;
    
}
