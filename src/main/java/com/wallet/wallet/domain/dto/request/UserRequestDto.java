package com.wallet.wallet.domain.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    //private Role role;

    private Boolean deleted = Boolean.FALSE;
}
