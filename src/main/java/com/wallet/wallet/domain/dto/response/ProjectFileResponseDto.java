package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProjectFileResponseDto {

    private String type;

    private String url;

    private String textEs;

    private String textEn;

    private Boolean isCover;

    private Integer orderIndex;

}
