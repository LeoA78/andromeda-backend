package com.spring.app.services;

import com.spring.app.dtos.request.OrderDTO;
import com.spring.app.dtos.response.OrderResponseDTO;

public interface IOrderService {
    OrderResponseDTO createOrder(OrderDTO orderDTO);
}
