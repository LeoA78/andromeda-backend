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
        value = "OrderDetailResponseDTO",
        description = "Represents the data returned to Order detail"
)
public class OrderDetailResponseDTO implements Serializable {

    private Long id;

    @ApiModelProperty(position = 1, required = true, notes = "The quantity is required.")
    private Integer quantity;

    @ApiModelProperty(position = 2, required = true, notes = "The price is required.")
    private Double price;

    @ApiModelProperty(position = 3, required = true, notes = "The product name is required.")
    private String productName;
}
