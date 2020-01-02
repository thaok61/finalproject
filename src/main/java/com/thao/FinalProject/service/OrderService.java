package com.thao.FinalProject.service;

import java.util.List;

import com.thao.FinalProject.model.Order;

public interface OrderService {
	public void addOrder(Order o);

	public void updateOrder(Order o);

	public List<Order> listOrders();

	public Order getOrderById(int id);

	public void removeOrder(int id);
}
