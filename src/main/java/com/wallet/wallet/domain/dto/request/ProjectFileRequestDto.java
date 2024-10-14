package com.wallet.wallet.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class ProjectFileRequestDto {

    private String type;

    private String url;

    private String textEs;

    private String textEn;

    private Boolean isCover;

    private Integer orderIndex;

    private Long projectId;

}
