package com.spring.app.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "OrderDetailDTO",
        description = "Represents the necessary data for the created order detail"
)
public class OrderDetailDTO {

    @ApiModelProperty(position = 1, required = true, notes = "The product id is required.")
    @NotNull(message = "Cannot be null")
    private Long productId;

    @ApiModelProperty(position = 2, required = true, notes = "The quantity is required.")
    @NotNull(message = "Cannot be null")
    private Integer quantity;

}
