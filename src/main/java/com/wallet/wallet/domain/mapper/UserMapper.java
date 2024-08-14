package com.wallet.wallet.domain.mapper;

import com.wallet.wallet.domain.dto.request.UserRequestDto;
import com.wallet.wallet.domain.dto.response.UserResponseDto;
import com.wallet.wallet.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements IMapper<User, UserResponseDto, UserRequestDto>{

    public abstract User requestDtoToEntity(UserRequestDto userRequestDto);
}
