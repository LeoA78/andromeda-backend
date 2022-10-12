package com.spring.app.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@ApiModel(
        value = "UserResponseDTO",
        description = "Represents the data returned to Users"
)
public class UserResponseDTO implements Serializable {
    private Long id;

    @ApiModelProperty(position = 1, required = true, notes = "The name is required.")
    private String name;

    @ApiModelProperty(position = 2, required = true, notes = "The last name is required.")
    private String lastName;

    @ApiModelProperty(position = 3, required = true, notes = "The email is required.")
    private String email;

    @ApiModelProperty(position = 4, required = true, notes = "The date of birth is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateOfBirth;

    @ApiModelProperty(position = 5, required = true, notes = "The category id is required.")
    private List<AddressResponseDTO> addressesList;

}
