package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Product;
import com.example.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
	@Autowired
    ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}