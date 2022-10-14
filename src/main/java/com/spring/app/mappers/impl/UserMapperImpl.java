package com.spring.app.mappers.impl;

import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.UserLoginResponseDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.User;
import com.spring.app.mappers.IUserMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapperImpl implements IUserMapper {

    private final ModelMapper modelMapper;

    @Override
    public UserResponseDTO entityToResponseDto(User entity) {
        return modelMapper.map(entity, UserResponseDTO.class);
    }

    @Override
    public User requestDtoToEntity(UserLoginDTO requestDto) {
        return modelMapper.map(requestDto, User.class);
    }

    @Override
    public User requestDtoToEntity(UserRegisterDTO requestDto) {
        return modelMapper.map(requestDto, User.class);
    }

    @Override
    public UserLoginResponseDTO entityToLoginResponseDto(User entity) {
        return modelMapper.map(entity, UserLoginResponseDTO.class);
    }


}
