package com.spring.app.services.impl;

import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.Address;
import com.spring.app.entities.User;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import com.spring.app.mappers.IUserMapper;
import com.spring.app.mappers.IAddressMapper;
import com.spring.app.repositories.IUserRepository;
import com.spring.app.services.IEmailService;
import com.spring.app.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    @Autowired
    private IEmailService emailService;

    @Override
    public User findUserByEmail(String email) {
        if (Objects.equals(email, "")) {
            throw new BadRequestException("El email no puede estar vacío.");
        }
        return userRepository.findByEmail(email);

    }

    @Override
    public UserResponseDTO userLogin(UserLoginDTO userLoginDTO){

        User userDataBase = findUserByEmail(userLoginDTO.getEmail());

        if(userDataBase == null || !BCrypt.checkpw(userLoginDTO.getPassword(), userDataBase.getPassword())){
            throw new NotFoundException("El usuario o la contraseña son incorrectos.");
        }



        return userMapper.entityToResponseDto(userDataBase);

    }

    @Override
    public UserResponseDTO userRegister(UserRegisterDTO userRegisterDTO){
        User userDataBase = findUserByEmail(userRegisterDTO.getEmail());

        if(userDataBase != null){
            throw new BadRequestException("El email utilizado no está disponible.");
        }

        User userToRegister = userMapper.requestDtoToEntity(userRegisterDTO);

        //Encriptamos la clave
        String password_hash = BCrypt.hashpw(userToRegister.getPassword(), BCrypt.gensalt(10));
        userToRegister.setPassword(password_hash);

        Address address = addressMapper.requestDtoToEntity(userRegisterDTO.getAddress());
        userToRegister.setAddress(address);
        userToRegister.setCreatedAt(LocalDateTime.now());



        User savedUser = userRepository.save(userToRegister);

        //emailService.sendEmail("altamiranopedroleonel@outlook.com","Registro Andromeda Store", "Gracias por registrarte en nuestro sitio web. Por favor verifica tu usuario para poder disfrutar de la tienda. \nUsuario: " + savedUser.getName() + " \nemail: " + savedUser.getEmail());

        return userMapper.entityToResponseDto(savedUser);
    }


}
