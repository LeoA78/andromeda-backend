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
        value = "UserRegisterDTO",
        description = "Represents the necessary data for register user"
)
public class UserRegisterDTO {

    @ApiModelProperty(position = 1, required = true, notes = "The name is required.")
    @NotNull(message = "Cannot be null")
    private String name;

    @ApiModelProperty(position = 2, required = true, notes = "The last name is required.")
    @NotNull(message = "Cannot be null")
    private String lastName;

    @ApiModelProperty(position = 3, required = true, notes = "The email is required.")
    @NotNull(message = "Cannot be null")
    @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$", message= "Invalid email")
    private String email;

    @ApiModelProperty(position = 4, required = true, notes = "The password is required.")
    @NotNull(message = "Cannot be null")
    private String password;

    @ApiModelProperty(position = 5, required = true, notes = "Address is required.")
    //@NotNull(message = "Cannot be null")
    private AddressDTO address;


}
