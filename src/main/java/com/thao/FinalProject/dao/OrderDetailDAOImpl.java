package com.thao.FinalProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thao.FinalProject.model.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailDAO.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addOrderDetail(OrderDetail p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("OrderDetail saved successfully, OrderDetail Details=" + p);
	}

	@Override
	public void updateOrderDetail(OrderDetail p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("OrderDetail updated successfully, OrderDetail Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> listOrderDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderDetail> orderDetailsList = session.createQuery("from OrderDetail").list();
		for (OrderDetail p : orderDetailsList) {
			logger.info("OrderDetail List::" + p);
		}
		return orderDetailsList;
	}

	@Override
	public OrderDetail getOrderDetailById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderDetail p = (OrderDetail) session.load(OrderDetail.class, new Integer(id));
		logger.info("OrderDetail loaded successfully, OrderDetail details=" + p);
		return p;
	}

	@Override
	public void removeOrderDetail(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderDetail p = (OrderDetail) session.load(OrderDetail.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("OrderDetail deleted successfully, OrderDetail details=" + p);
	}
}
