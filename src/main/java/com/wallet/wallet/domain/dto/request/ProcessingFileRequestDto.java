package com.wallet.wallet.domain.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProcessingFileRequestDto {

    @Schema(description = "Url de la imagen para Desktop", example = "Projectos")
    private String urlDesktop;

    @Schema(description = "Url de la imagen para Mobile", example = "Projects")
    private String urlMobile;

}
