package com.spring.app.services;

import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.dtos.response.PagesResponseDTO;

import java.util.List;

public interface ICategoryService {


    List<CategoryResponseDTO> findAllCategories();

    CategoryResponseDTO findCategoryByName(String name);
}
