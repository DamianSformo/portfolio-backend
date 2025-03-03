package com.portfolio.portfolio.api.service;

import com.portfolio.portfolio.domain.dto.request.AuthenticationRequest;
import com.portfolio.portfolio.domain.dto.request.UserRequestDto;
import com.portfolio.portfolio.domain.dto.response.UserRegisterResponseDto;
import com.portfolio.portfolio.domain.dto.response.UserResponseDto;
import com.portfolio.portfolio.domain.model.User;

public interface IUserService {

    UserRegisterResponseDto save(UserRequestDto dto);

    UserResponseDto authenticate(AuthenticationRequest dto);

    User getByEmail(String email);

    UserRegisterResponseDto activate(Long id);

}
