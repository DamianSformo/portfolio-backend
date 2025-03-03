package com.portfolio.portfolio.api.service.impl;

import com.portfolio.portfolio.api.controller.Security.jwt.JwtUtil;
import com.portfolio.portfolio.api.service.IUserService;
import com.portfolio.portfolio.domain.dto.request.AuthenticationRequest;
import com.portfolio.portfolio.domain.dto.request.UserRequestDto;
import com.portfolio.portfolio.domain.dto.response.UserRegisterResponseDto;
import com.portfolio.portfolio.domain.dto.response.UserResponseDto;
import static com.portfolio.portfolio.domain.enums.EMessageCode.*;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.mapper.UserMapper;
import com.portfolio.portfolio.domain.model.User;
import com.portfolio.portfolio.domain.repository.IUserRepository;
import com.portfolio.portfolio.handler.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

   private final IUserRepository repository;
   private final UserMapper mapper;
   private final PasswordEncoder encoder;
   private final MessageSource messenger;

   @Override
   public UserRegisterResponseDto save(UserRequestDto dto) {
      dto.setPassword(encoder.encode(dto.getPassword()));
      User savedUser = repository.save(mapper.requestDtoToEntity(dto));
      return mapper.entityToUserRegisterResponseDto(savedUser);
   }

   @Override
   public UserResponseDto authenticate(AuthenticationRequest dto) {
      User user = getByEmail(dto.getEmail());

      if (!encoder.matches(dto.getPassword(), user.getPassword())) {
         throw new BadCredentialsException("Email o contraseña incorrectos");
      }

      UserResponseDto userResponseDto = mapper.entityToResponseDto(user);
      userResponseDto.setJwt(JwtUtil.generateToken(user));
      return userResponseDto;
   }

   public User getByEmail(String email) {
      return repository.findByEmail(email).orElseThrow(
         () -> new ResourceNotFoundException(messenger.getMessage(USER_NOT_FOUND_BY_EMAIL.name(),
                 new Object[] { email }, Locale.getDefault())));
   }

   public UserRegisterResponseDto getById(Long id) {
      User user = repository.findById(id).orElseThrow(
         () -> new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                 new Object[] { User.class.getSimpleName(), id }, Locale.getDefault())));

      return mapper.entityToUserRegisterResponseDto(user);
   }

   @Override
   public UserRegisterResponseDto activate(Long id) {
      User existing = repository.findById(id).orElseThrow(() ->
              new ResourceNotFoundException(messenger.getMessage(RESOURCE_NOT_FOUND_BY_ID.name(),
                      new Object[] {"User", id}, Locale.getDefault())));

      if (ERecordStatus.A.equals(existing.getRecordStatus())) {
         existing.setRecordStatus(ERecordStatus.D);
      } else {
         existing.setRecordStatus(ERecordStatus.A);
      }

      repository.save(existing);

      return getById(id);
   }

}

