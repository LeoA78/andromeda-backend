package com.spring.app.services.impl;

import com.spring.app.dtos.request.OrderDTO;
import com.spring.app.dtos.request.OrderDetailDTO;
import com.spring.app.dtos.response.OrderResponseDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.entities.Order;
import com.spring.app.entities.OrderDetail;
import com.spring.app.entities.Product;
import com.spring.app.entities.User;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import com.spring.app.mappers.IOrderMapper;
import com.spring.app.mappers.IProductMapper;
import com.spring.app.repositories.IOrderRepository;
import com.spring.app.services.IOrderService;
import com.spring.app.services.IProductService;
import com.spring.app.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderMapper orderMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductMapper productMapper;

    @Override
    public OrderResponseDTO createOrder(OrderDTO orderDTO) {

        User userExist = userService.findUserByEmail(orderDTO.getUserEmail());

        if(userExist == null){
            throw new NotFoundException("Email does not exist");
        }

        List<OrderDetail> orderDetailList = new ArrayList<>();

        if(orderDTO.getCart().isEmpty()){
            throw new BadRequestException("El carrito no puede estar vacío.");
        }

        Order orderToCreate = new Order();

        Double orderTotal = (double) 0;

        for (OrderDetailDTO orderDetailRequest : orderDTO.getCart()) {

            ProductResponseDTO productResponseDTO = productService.findProductById(orderDetailRequest.getProductId());

            if(productResponseDTO == null){
                throw new NotFoundException("Some of the products are not valid");
            }
            Product product = productMapper.responseDtoToEntity(productResponseDTO);

            if(orderDetailRequest.getQuantity() < 1){
                throw new NotFoundException("Quantity must not be negative or zero");
            }

            if(orderDetailRequest.getQuantity() > product.getStock()){
                throw new NotFoundException("Alguno de los productos no tiene stock.");
            }

            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setQuantity(orderDetailRequest.getQuantity());
            orderDetail.setPrice(orderDetailRequest.getQuantity() * product.getUnitPrice());
            orderDetail.setCreatedAt(LocalDateTime.now());
            orderDetail.setProduct(product);
            orderDetail.setOrder(orderToCreate);

            orderTotal += orderDetail.getPrice();

            productService.updateStockProduct( product.getId(),orderDetailRequest.getQuantity());

            orderDetailList.add(orderDetail);
        }

        orderToCreate.setOrderDetailsList(orderDetailList);
        orderToCreate.setCreatedAt(LocalDateTime.now());
        orderToCreate.setTotal(orderTotal);
        orderToCreate.setUser(userExist);



        Order savedOrder = orderRepository.save(orderToCreate);

        return orderMapper.entityToResponseDto(savedOrder);
    }


}
