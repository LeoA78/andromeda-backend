package com.spring.app.repositories;

import com.spring.app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
