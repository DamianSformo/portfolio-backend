package com.portfolio.portfolio.domain.dto.request;

import com.portfolio.portfolio.domain.enums.ERole;
import lombok.Data;

@Data
public class UserRequestDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private ERole role;
}
