package com.wallet.wallet.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StatementResponseDtoLang {

    @Schema(type = "long", example = "test")
    private Long id;

    @Schema(type = "string", example = "test")
    private String statement;

}
