package com.portfolio.portfolio.domain.dto.request;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;


}