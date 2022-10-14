package com.spring.app.mappers.impl;

import com.spring.app.dtos.response.OrderDetailResponseDTO;
import com.spring.app.dtos.response.OrderResponseDTO;
import com.spring.app.dtos.response.UserResponseDTO;
import com.spring.app.entities.Order;
import com.spring.app.entities.OrderDetail;
import com.spring.app.mappers.IOrderMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderMapperImpl implements IOrderMapper {

    private final ModelMapper modelMapper;

    @Override
    public OrderResponseDTO entityToResponseDto(Order entity) {

        List<OrderDetailResponseDTO> orderDetailResponseDTOList = new ArrayList<>();

        for(OrderDetail orderDetail : entity.getOrderDetailsList()){
            orderDetailResponseDTOList.add(modelMapper.map(orderDetail, OrderDetailResponseDTO.class));
        }

        UserResponseDTO userResponseDTO = modelMapper.map(entity.getUser(), UserResponseDTO.class);

        return OrderResponseDTO.builder()
                .id(entity.getId())
                .user(userResponseDTO)
                .orderDetail(orderDetailResponseDTOList)
                .createdAt(entity.getCreatedAt())
                .total(entity.getTotal())
                .build();
    }

}
