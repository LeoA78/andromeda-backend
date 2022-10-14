package com.spring.app.controllers;

import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.request.UserLoginDTO;
import com.spring.app.dtos.request.UserRegisterDTO;
import com.spring.app.dtos.response.DataResponseDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.dtos.response.UserLoginResponseDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.services.IUserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@AllArgsConstructor
@Api(value = "User Api", tags = {"User Service"})
@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private IUserService userService;

    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to user Logged in",
            httpMethod = "POST",
            response = UserLoginResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with information about a successfully user logged in",
                    response = UserLoginResponseDTO.class),
            @ApiResponse(
                    code = 400,
                    message = "Information about an error login")
    })
    public ResponseEntity<DataResponseDTO<UserLoginResponseDTO>> userLogin(
            @ApiParam(name = "user", required = true, value = "User")
            @Valid @RequestBody UserLoginDTO user) {

        UserLoginResponseDTO userLoginResponseDTO = userService.userLogin(user);

        DataResponseDTO<UserLoginResponseDTO> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(userLoginResponseDTO);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/user/login");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to registered user",
            httpMethod = "POST",
            response = UserResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with information about a successfully registered user",
                    response = UserResponseDTO.class),
            @ApiResponse(
                    code = 400,
                    message = "Information about an error register")
    })
    public ResponseEntity<DataResponseDTO<UserResponseDTO>> userRegister(
            @ApiParam(name = "user", required = true, value = "User")
            @Valid @RequestBody UserRegisterDTO user) {

        UserResponseDTO userResponseDTO = userService.userRegister(user);

        DataResponseDTO<UserResponseDTO> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(userResponseDTO);
        result.setResponseCode(HttpStatus.CREATED.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/user/register");

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
