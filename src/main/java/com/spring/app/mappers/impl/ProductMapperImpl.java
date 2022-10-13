package com.spring.app.mappers.impl;


import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.entities.Product;
import com.spring.app.mappers.IProductMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapperImpl implements IProductMapper {
    private final ModelMapper modelMapper;

    @Override
    public ProductResponseDTO entityToResponseDto(Product entity) {
        return modelMapper.map(entity, ProductResponseDTO.class);
    }

    @Override
    public Product requestDtoToEntity(ProductDTO requestDto) {
        return modelMapper.map(requestDto, Product.class);
    }

}
