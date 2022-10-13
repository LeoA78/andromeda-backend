package com.spring.app.mappers;

import com.spring.app.dtos.request.CategoryDTO;
import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.entities.Category;

public interface ICategoryMapper {
    CategoryResponseDTO entityToResponseDto(Category entity);

    Category requestDtoToEntity(CategoryDTO requestDto);

    Category responseDtoToEntity(CategoryResponseDTO responseDto);
}
