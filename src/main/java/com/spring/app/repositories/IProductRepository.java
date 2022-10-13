package com.spring.app.repositories;


import com.spring.app.entities.Category;
import com.spring.app.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategory(Category category, Pageable pageable);

}
