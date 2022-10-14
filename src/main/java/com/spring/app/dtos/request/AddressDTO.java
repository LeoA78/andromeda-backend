package com.spring.app.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "AddressDTO",
        description = "Represents the data needed to created Address"
)
public class AddressDTO implements Serializable {

    @ApiModelProperty(position = 1, required = true, notes = "The street name is required.")
    @NotNull
    private String street;

    @ApiModelProperty(position = 2, required = true, notes = "The number is required.")
    @NotNull
    private String streetNumber;

    @ApiModelProperty(position = 3, notes = "The apartment is optional.")
    private String apartment;

    @ApiModelProperty(position = 4, required = true, notes = "The postal code is required.")
    @NotNull
    private String postcode;

}
