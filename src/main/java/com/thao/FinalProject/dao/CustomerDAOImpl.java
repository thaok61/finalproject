package com.thao.FinalProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thao.FinalProject.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Customer saved successfully, Customer Details=" + c);
	}

	@Override
	public void updateCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Customer updated successfully, Customer Details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> categoriesList = session.createQuery("from Customer").list();
		for (Customer c : categoriesList) {
			logger.info("Customer List::" + c);
		}
		return categoriesList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Customer loaded successfully, Customer details=" + c);
		return c;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
		logger.info("Customer deleted successfully, Customer details=" + c);
	}
}
