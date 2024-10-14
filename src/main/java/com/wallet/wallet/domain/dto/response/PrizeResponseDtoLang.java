package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

@Data
public class PrizeResponseDtoLang {

    private Long id;

    private Integer year;

    private String title;

    private Integer orderIndex;

    private ERecordStatus recordStatus;
    
}
