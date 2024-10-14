package com.wallet.wallet.domain.dto.response;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import java.util.List;

@Data
public class MenuResponseDto {

    private Long id;

    private String titleEs;

    private String titleEn;

    private String router;

    private Integer orderIndex;

    private ERecordStatus recordStatus;
}
