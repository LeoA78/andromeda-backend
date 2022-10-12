package com.spring.app.dtos.response;

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
    private AddressResponseDTO address;

    @ApiModelProperty(position = 2, required = true, notes = "The date is required.")
    private LocalDateTime createdAt;

    @ApiModelProperty(position = 3, required = true, notes = "The order detail is required.")
    private List<OrderDetailResponseDTO> orderDetail;
}
