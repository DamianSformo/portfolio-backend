package com.portfolio.portfolio.domain.mapper;

import com.portfolio.portfolio.domain.dto.request.UserRequestDto;
import com.portfolio.portfolio.domain.dto.response.UserRegisterResponseDto;
import com.portfolio.portfolio.domain.dto.response.UserResponseDto;
import com.portfolio.portfolio.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements IMapper<User, UserResponseDto, UserRequestDto>{

    public abstract User requestDtoToEntity(UserRequestDto userRequestDto);
    public abstract UserRegisterResponseDto entityToUserRegisterResponseDto(User user);

}
