package com.thao.FinalProject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.thao.FinalProject.dao.OrderDAO;
import com.thao.FinalProject.model.Order;

public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO;

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	@Transactional
	public void addOrder(Order o) {
		this.orderDAO.addOrder(o);
	}

	@Override
	@Transactional
	public void updateOrder(Order o) {
		this.orderDAO.updateOrder(o);
	}

	@Override
	@Transactional
	public List<Order> listOrders() {
		return this.orderDAO.listOrders();
	}

	@Override
	@Transactional
	public Order getOrderById(int id) {
		return this.orderDAO.getOrderById(id);
	}

	@Override
	@Transactional
	public void removeOrder(int id) {
		this.orderDAO.removeOrder(id);
	}
}
