package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    public Page<Product> getProducts(int page, int size) {
//        return productRepository.findAll(PageRequest.of(page, size));
//    }
    
    public Page<Product>getProducts(int page, int size, String sortBy) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

}
