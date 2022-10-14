package com.spring.app.dtos.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "OrderDTO",
        description = "Represents the necessary data for the created order"
)
public class OrderDTO {

    @ApiModelProperty(position = 1, required = true, notes = "The user email is required.")
    @NotNull(message = "Cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message= "Invalid email")
    private String userEmail;

    @ApiModelProperty(position = 3, required = true, notes = "Cart is required.")
    //@NotNull(message = "Cannot be null")
    private List<OrderDetailDTO> cart = new ArrayList<>();

}
