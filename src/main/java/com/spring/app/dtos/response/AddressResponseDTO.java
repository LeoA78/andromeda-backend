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
        value = "AddressResponseDTO",
        description = "Represents the data returned to Address"
)
public class AddressResponseDTO implements Serializable {

    private Long addressId;

    @ApiModelProperty(position = 1, notes = "The street name is required.")
    private String street;

    @ApiModelProperty(position = 2, notes = "The number is required.")
    private String streetNumber;

    @ApiModelProperty(position = 3, notes = "The apartment is optional.")
    private String apartment;

    @ApiModelProperty(position = 4, notes = "The postal code is required.")
    private String postCode;

    @ApiModelProperty(position = 5, notes = "The city is required.")
    private String city;

    @ApiModelProperty(position = 6, notes = "The province is required.")
    private String province;

}
