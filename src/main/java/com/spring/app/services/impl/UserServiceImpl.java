package com.spring.app.services.impl;

import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.UserLoginResponseDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.Address;
import com.spring.app.entities.User;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import com.spring.app.mappers.IUserMapper;
import com.spring.app.mappers.impl.IAddressMapper;
import com.spring.app.repositories.IUserRepository;
import com.spring.app.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private IAddressMapper addressMapper;

    @Override
    public User findUserByEmail(String email) {
        if (Objects.equals(email, "")) {
            throw new BadRequestException("the email cannot be empty.");
        }
        return userRepository.findByEmail(email);

    }

    @Override
    public UserLoginResponseDTO userLogin(UserLoginDTO userLoginDTO){

        User userDataBase = findUserByEmail(userLoginDTO.getEmail());

        if(userDataBase == null || !Objects.equals(userDataBase.getPassword(), userLoginDTO.getPassword())){
            throw new NotFoundException("The email or password are not valid");
        }

        return userMapper.entityToLoginResponseDto(userDataBase);

    }

    @Override
    public UserResponseDTO userRegister(UserRegisterDTO userRegisterDTO){
        User userDataBase = findUserByEmail(userRegisterDTO.getEmail());

        if(userDataBase != null){
            throw new BadRequestException("User email already exist");
        }

        User userToRegister = userMapper.requestDtoToEntity(userRegisterDTO);

        Address address = addressMapper.requestDtoToEntity(userRegisterDTO.getAddress());
        userToRegister.setAddress(address);
        userToRegister.setCreatedAt(LocalDateTime.now());


        User savedUser = userRepository.save(userToRegister);

        return userMapper.entityToResponseDto(savedUser);
    }


}
