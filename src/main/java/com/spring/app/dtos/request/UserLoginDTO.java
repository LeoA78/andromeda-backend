package com.spring.app.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "UserLoginDTO",
        description = "Represents the necessary data for login user"
)
public class UserLoginDTO {

    @ApiModelProperty(position = 1, required = true, notes = "The email is required.")
    @NotNull(message = "Cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message= "Invalid email")
    private String email;

    @ApiModelProperty(position = 2, required = true, notes = "The password is required.")
    @NotNull(message = "Cannot be null")
    private String password;

}
