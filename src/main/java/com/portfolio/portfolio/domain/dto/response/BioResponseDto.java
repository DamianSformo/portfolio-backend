package com.portfolio.portfolio.domain.dto.response;

import lombok.Data;

@Data
public class BioResponseDto {

    private Long id;

    private String name;

    private String urlPhoto;

    private String textPhotoEs;

    private String textPhotoEn;

    private String bioEs;

    private String bioEn;
}
