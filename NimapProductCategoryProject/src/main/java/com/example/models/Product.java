package com.example.models;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
public class Product {
	
	@Id
	int productid;
	String productname;
	
	@OneToMany
	@JoinColumn(name ="categoryid")
	int categoryid;

	@Autowired
	Category category;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", categoryid=" + categoryid
				+ ", category name=" + category + "]";
	}

	public Product(int productid, String productname, int categoryid, Category category) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.categoryid = categoryid;
		this.category = category;
	}

	public Product() {
		super();
	}
	
	
}
