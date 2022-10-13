package com.spring.app.services;

import com.spring.app.dtos.response.CategoryResponseDTO;

public interface ICategoryService {
    CategoryResponseDTO findCategoryByName(String name);
}
