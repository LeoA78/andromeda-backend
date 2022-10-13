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
        value = "ProductDTO",
        description = "Represents the necessary data for the created product"
)
public class ProductDTO {

    @ApiModelProperty(position = 1, required = true, notes = "The name is required.")
    @NotNull(message = "Cannot be null")
    private String name;

    @ApiModelProperty(position = 2, required = true, notes = "The description is required.")
    @NotNull(message = "Cannot be null")
    private String description;

    @ApiModelProperty(position = 3, required = true, notes = "The price is required.")
    @NotNull(message = "Cannot be null")
    private Double unitPrice;

    @ApiModelProperty(position = 4, required = true, notes = "The stock is required.")
    @NotNull(message = "Cannot be null")
    private Integer stock;

    @ApiModelProperty(position = 5, required = true, notes = "The image is required.")
    @NotNull(message = "Cannot be null")
    private String imageUrl;

    @ApiModelProperty(position = 6, required = true, notes = "The category is required.")
    @NotNull(message = "Cannot be null")
    private String categoryName;


}
