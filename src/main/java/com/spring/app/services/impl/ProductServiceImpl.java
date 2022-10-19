package com.spring.app.services.impl;

import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.dtos.response.PagesResponseDTO;
import com.spring.app.entities.Product;
import com.spring.app.entities.Category;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import com.spring.app.mappers.ICategoryMapper;
import com.spring.app.mappers.IProductMapper;
import com.spring.app.repositories.IProductRepository;
import com.spring.app.services.ICategoryService;
import com.spring.app.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    private ICategoryMapper categoryMapper;

    @Override
    public PagesResponseDTO<ProductResponseDTO> findAllProducts(Integer page, Integer size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("The page cannot be less than zero and the size less than one");
        }

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPageList = productRepository.findAll(pageable);

        if (productPageList.isEmpty()) {
            throw new NotFoundException("There are no records related to products");
        }

        PagesResponseDTO<ProductResponseDTO> productPageResponseDTO = new PagesResponseDTO<>();

        for (Product product : productPageList) {
            productPageResponseDTO.getResults().add(productMapper.entityToResponseDto(product));
        }

        productPageResponseDTO.setTotalPages(productPageList.getTotalPages());
        productPageResponseDTO.setCurrentPage(productPageList.getNumber() + 1);
        productPageResponseDTO.setPageSize(productPageList.getSize());
        productPageResponseDTO.setTotalElements((int) productPageList.getTotalElements());

        return productPageResponseDTO;
    }

    @Override
    public ProductResponseDTO findProductById(Long id) {

        if (id < 0) {
            throw new BadRequestException("the id cannot be a negative number. Request ID:" + id);
        }

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Record with id " + id + " does not exist.");
        }

        return productMapper.entityToResponseDto(optionalProduct.get());
    }

    @Override
    public PagesResponseDTO<ProductResponseDTO> findProductsByCategory(Integer page, Integer size, String category) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("The page cannot be less than zero and the size less than one");
        }

        CategoryResponseDTO categoryResponseDTO = categoryService.findCategoryByName(category);
        Category filteredCategory = categoryMapper.responseDtoToEntity(categoryResponseDTO);


        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPageList = productRepository.findAllByCategory(filteredCategory, pageable);

        if (productPageList.isEmpty()) {
            throw new NotFoundException("There are no records related to products");
        }

        PagesResponseDTO<ProductResponseDTO> productPageResponseDTO = new PagesResponseDTO<>();

        for (Product product : productPageList) {
            productPageResponseDTO.getResults().add(productMapper.entityToResponseDto(product));
        }

        productPageResponseDTO.setTotalPages(productPageList.getTotalPages());
        productPageResponseDTO.setCurrentPage(productPageList.getNumber() + 1);
        productPageResponseDTO.setPageSize(productPageList.getSize());
        productPageResponseDTO.setTotalElements((int) productPageList.getTotalElements());

        return productPageResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductDTO productDTO) {

        CategoryResponseDTO categoryResponse = categoryService.findCategoryByName(productDTO.getCategoryName());
        Category categoryByName = categoryMapper.responseDtoToEntity(categoryResponse);

        if (categoryByName == null) {
            throw new BadRequestException("Cannot create a category without an associated customer");
        }

        Product productToCreate = productMapper.requestDtoToEntity(productDTO);
        productToCreate.setCategory(categoryByName);
        categoryByName.getProductsList().add(productToCreate);
        Product createdProduct = productRepository.save(productToCreate);

        return productMapper.entityToResponseDto(createdProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductDTO productDTO){

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Product to update not found");
        }

        CategoryResponseDTO categoryResponse = categoryService.findCategoryByName(productDTO.getCategoryName());
        Category categoryByName = categoryMapper.responseDtoToEntity(categoryResponse);

        if (categoryByName == null) {
            throw new BadRequestException("Cannot create a category without an associated customer");
        }

        Product product = productMapper.requestDtoToEntity(productDTO);
        product.setId(id);
        product.setCategory(categoryByName);

        Product updatedProduct = productRepository.save(product);

        return productMapper.entityToResponseDto(updatedProduct);
    }

    @Override
    public ProductResponseDTO updateStockProduct(Long id, Integer quantity){

        if(quantity <= 0){
            throw new BadRequestException("quantity must be greater than zero");
        }

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new NotFoundException("Product to update not found");
        }

        Product product = optionalProduct.get();
        Integer stock = product.getStock();

        if((stock - quantity) < 0){
            throw new RuntimeException("Stock not available for that quantity");
        }

        product.setStock(stock-quantity);

        Product updatedProduct = productRepository.save(product);

        return productMapper.entityToResponseDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()) {
            throw new RuntimeException("Product to delete not found");
        }

        productRepository.delete(optionalProduct.get());
    }



}
