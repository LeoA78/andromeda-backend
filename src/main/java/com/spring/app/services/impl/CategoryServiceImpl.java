package com.spring.app.services.impl;

import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.dtos.response.PagesResponseDTO;
import com.spring.app.entities.Category;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import com.spring.app.mappers.ICategoryMapper;
import com.spring.app.repositories.ICategoryRepository;
import com.spring.app.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ICategoryMapper categoryMapper;



    @Override
    public List<CategoryResponseDTO> findAllCategories() {
 
        List<Category> categoryList = categoryRepository.findAll();

        if (categoryList.isEmpty()) {
            throw new NotFoundException("There are no records related to categories");
        }

        List<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();

        for (Category category : categoryList) {
            categoryResponseDTOList.add(categoryMapper.entityToResponseDto(category));
        }
        return categoryResponseDTOList;
    }
    
    @Override
    public CategoryResponseDTO findCategoryByName(String name) {

        if (Objects.equals(name, "")) {
            throw new BadRequestException("Name cannot be empty.");
        }

        Optional<Category> category = categoryRepository.findByName(name);

        if (!category.isPresent()) {
            throw new NotFoundException("Category with name " + name + " does not exist");
        }

        return categoryMapper.entityToResponseDto(category.get());
    }
}
