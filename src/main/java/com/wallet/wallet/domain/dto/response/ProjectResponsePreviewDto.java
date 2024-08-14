package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ProjectResponsePreviewDto {

    private Long id;

    private String title;

    private Integer year;

    private Integer orderIndex;

    private ProjectFileResponseDto projectFile;
}
