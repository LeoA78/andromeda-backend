package com.spring.app.mappers;

import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.User;

public interface IUserMapper {
    UserResponseDTO entityToResponseDto(User entity);

    User requestDtoToEntity(UserLoginDTO requestDto);

    User requestDtoToEntity(UserRegisterDTO requestDto);

}
