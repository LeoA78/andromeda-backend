package com.spring.app.services;

import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.UserLoginResponseDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.User;

public interface IUserService {

    User findUserByEmail(String email);

    UserLoginResponseDTO userLogin(UserLoginDTO userLoginDTO);

    UserResponseDTO userRegister(UserRegisterDTO userRegisterDTO);
}
