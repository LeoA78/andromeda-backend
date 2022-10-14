package com.spring.app.mappers;

import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.entities.Product;

public interface IProductMapper {
    ProductResponseDTO entityToResponseDto(Product product);

    Product requestDtoToEntity(ProductDTO requestDto);

    Product responseDtoToEntity(ProductResponseDTO responseDto);
}
