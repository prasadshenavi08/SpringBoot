package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
