package com.spring.app.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@ApiModel(
        value = "ProductLoginResponseDTO",
        description = "Represents the data returned to login Users"
)
public class UserLoginResponseDTO implements Serializable {
    private Long id;

    @ApiModelProperty(position = 1, required = true, notes = "The name is required.")
    private String name;

    @ApiModelProperty(position = 2, required = true, notes = "The last name is required.")
    private String lastName;

    @ApiModelProperty(position = 3, required = true, notes = "The email is required.")
    private String email;


}
