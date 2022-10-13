package com.spring.app.services;

import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.response.PagesResponseDTO;
import com.spring.app.dtos.response.ProductResponseDTO;

public interface IProductService {
    PagesResponseDTO<ProductResponseDTO> findAllProducts(Integer page, Integer size);

    ProductResponseDTO findProductById(Long id);

    PagesResponseDTO<ProductResponseDTO> findProductsByCategory(Integer page, Integer size, String category);

    ProductResponseDTO createProduct(ProductDTO productDTO);

    ProductResponseDTO updateProduct(Long id, ProductDTO productDTO);

    ProductResponseDTO updateStockProduct(Long id, Integer quantity);

    void deleteProductById(Long id);
}
