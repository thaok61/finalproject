package com.thao.FinalProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thao.FinalProject.dao.CategoryDAO;
import com.thao.FinalProject.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	@Transactional
	public void addCategory(Category p) {
		this.categoryDAO.addCategory(p);
	}

	@Override
	@Transactional
	public void updateCategory(Category p) {
		this.categoryDAO.updateCategory(p);
	}

	@Override
	@Transactional
	public List<Category> listCategories() {
		return this.categoryDAO.listCategories();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void removeCategory(int id) {
		this.categoryDAO.removeCategory(id);
	}
}
