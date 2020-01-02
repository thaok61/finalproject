package com.thao.FinalProject.service;

import java.util.List;

import com.thao.FinalProject.model.Product;

public interface ProductService {
	public void addProduct(Product c);

	public void updateProduct(Product c);

	public List<Product> listProducts();

	public Product getProductById(int id);

	public void removeProduct(int id);
}
