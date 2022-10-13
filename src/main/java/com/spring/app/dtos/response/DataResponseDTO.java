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
        value = "DataResponseDTO",
        description = "Represents the data returned to data"
)
public class DataResponseDTO<ResponseDTO> implements Serializable {

    @ApiModelProperty(position = 1, required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:MM:SS")
    private LocalDateTime timestamp;

    @ApiModelProperty(position = 2, required = true)
    private Integer responseCode;

    @ApiModelProperty(position = 3, required = true)
    private String status;

    @ApiModelProperty(position = 4, required = true)
    private String message;

    @ApiModelProperty(position = 5, required = true)
    private String path;

    @ApiModelProperty(position = 6, required = true)
    private ResponseDTO data;

}
