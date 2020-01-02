package com.thao.FinalProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thao.FinalProject.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAO.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Category saved successfully, Category Details=" + c);
	}

	@Override
	public void updateCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Category updated successfully, Category Details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoriesList = session.createQuery("from Category").list();
		for (Category c : categoriesList) {
			logger.info("Category List::" + c);
		}
		return categoriesList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, Category details=" + c);
		return c;
	}

	@Override
	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = (Category) session.load(Category.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
		logger.info("Category deleted successfully, Category details=" + c);
	}
}
