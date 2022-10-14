package com.spring.app.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
        value = "OrderResponseDTO",
        description = "Represents the data returned to Order"
)
public class OrderResponseDTO implements Serializable {

    private Long id;

    @ApiModelProperty(position = 1, required = true, notes = "The address is required.")
    private UserResponseDTO user;

    @ApiModelProperty(position = 2, required = true, notes = "The date is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:SS")
    private LocalDateTime createdAt;

    @ApiModelProperty(position = 3, required = true, notes = "The total is required.")
    private Double total;

    @ApiModelProperty(position = 4, required = true, notes = "The order detail is required.")
    private List<OrderDetailResponseDTO> orderDetail;
}
