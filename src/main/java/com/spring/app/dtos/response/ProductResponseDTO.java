package com.spring.app.dtos.response;

import com.spring.app.entities.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@ApiModel(
        value = "ProductResponseDTO",
        description = "Represents the data needed to created Product"
)
public class ProductResponseDTO implements Serializable {

    private Long productId;

    @ApiModelProperty(position = 1, required = true, notes = "The name is required.")
    private String name;

    @ApiModelProperty(position = 2, required = true, notes = "The description is required.")
    private String description;

    @ApiModelProperty(position = 3, required = true, notes = "The unit price is required.")
    private Double unitPrice;

    @ApiModelProperty(position = 4, required = true, notes = "The stock is required.")
    private Integer stock;

    @ApiModelProperty(position = 5, required = true, notes = "The image url is required.")
    private String imageUrl;

    @ApiModelProperty(position = 6, required = true, notes = "The category id is required.")
    private CategoryResponseDTO category;
}
