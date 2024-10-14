package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.ERecordStatus;
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
