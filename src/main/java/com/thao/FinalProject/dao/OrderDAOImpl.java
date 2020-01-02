package com.thao.FinalProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thao.FinalProject.model.Order;

public class OrderDAOImpl implements OrderDAO{
	private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addOrder(Order o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Order saved successfully, Order =" + o);
	}

	@Override
	public void updateOrder(Order o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
		logger.info("Order updated successfully, Order =" + o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> listOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> ordersList = session.createQuery("from Order").list();
		for (Order o : ordersList) {
			logger.info("Order List:" + o);
		}
		return ordersList;
	}

	@Override
	public Order getOrderById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order o = (Order) session.load(Order.class, new Integer(id));
		logger.info("Order loaded successfully, Order =" + o);
		return o;
	}

	@Override
	public void removeOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order o = (Order) session.load(Order.class, new Integer(id));
		if (null != o) {
			session.delete(o);
		}
		logger.info("Order deleted successfully, Order =" + o);
	}
}
