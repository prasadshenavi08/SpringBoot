package com.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	public ProductRepository repo;
	
	@RequestMapping("")
	public String getAllProducts(Model model) {
		List <Product>products= repo.findAll();
		model.addAttribute("products",products);
		return "index";
	}
	@GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product"; // Return the view name (Thymeleaf template)
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        repo.save(product);
        return "redirect:/products"; // Redirect to the product list
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = repo.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "edit-product"; // Return the view name (Thymeleaf template)
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product productDetails) {
        Product product = repo.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            repo.save(product);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/products";
    }
}
