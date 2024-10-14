package com.wallet.wallet.domain.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MenuRequestDto {

    @Schema(description = "Título en español", example = "Projectos")
    private String titleEs;

    @Schema(description = "Título en inglés", example = "Projects")
    private String titleEn;

    @Schema(description = "Url", example = "/projects")
    private String router;

    @Schema(description = "Orden de todos los elementos", format = "number", example = "1")
    private Integer orderIndex;
}
