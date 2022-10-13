package com.spring.app.mappers.impl;


import com.spring.app.dtos.request.CategoryDTO;
import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.entities.Category;
import com.spring.app.mappers.ICategoryMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapperImpl implements ICategoryMapper {

    private final ModelMapper modelMapper;

    @Override
    public CategoryResponseDTO entityToResponseDto(Category entity) {
        return modelMapper.map(entity, CategoryResponseDTO.class);
    }

    @Override
    public Category requestDtoToEntity(CategoryDTO requestDto) {
        return modelMapper.map(requestDto, Category.class);
    }

    @Override
    public Category responseDtoToEntity(CategoryResponseDTO responseDto) {
        return modelMapper.map(responseDto, Category.class);
    }

}
