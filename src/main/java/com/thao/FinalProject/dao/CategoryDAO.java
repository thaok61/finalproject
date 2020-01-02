package com.thao.FinalProject.dao;

import java.util.List;

import com.thao.FinalProject.model.Category;

public interface CategoryDAO {
	public void addCategory(Category c);

	public void updateCategory(Category c);

	public List<Category> listCategories();

	public Category getCategoryById(int id);

	public void removeCategory(int id);
}
