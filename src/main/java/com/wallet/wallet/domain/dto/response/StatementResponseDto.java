package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StatementResponseDto {

    @Schema(type = "long", example = "test")
    private Long id;

    @Schema(type = "string", example = "test")
    private String statementEs;

    @Schema(type = "string", example = "test")
    private String statementEn;

    // Constructor que JPA puede usar para el mapeo
    public StatementResponseDto(Long id, String statementEs, String statementEn) {
        this.id = id;
        this.statementEs = statementEs;
        this.statementEn = statementEn;
    }

}
