package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
