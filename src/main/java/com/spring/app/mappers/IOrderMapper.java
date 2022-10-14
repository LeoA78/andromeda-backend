package com.spring.app.mappers;

import com.spring.app.dtos.response.OrderResponseDTO;
import com.spring.app.entities.Order;

public interface IOrderMapper {
    OrderResponseDTO entityToResponseDto(Order entity);
}
