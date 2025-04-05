package com.example.services;

import com.example.repository.CategoryRepository;
import com.example.models.Category; // Assuming this exists
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

//	public Category getCategory() {
//		return categoryRepository.save(category);
//	}
	public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
}
