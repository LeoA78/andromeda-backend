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
        value = "CategoryResponseDTO",
        description = "Represents the data returned to Category"
)
public class CategoryResponseDTO implements Serializable {
    @ApiModelProperty(position = 1, required = true, notes = "The category id is required.")
    private Long categoryId;

    @ApiModelProperty(position = 2, required = true, notes = "The name is required.")
    private String name;
}
