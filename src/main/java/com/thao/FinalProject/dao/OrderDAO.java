package com.thao.FinalProject.dao;

import java.util.List;

import com.thao.FinalProject.model.Order;

public interface OrderDAO {
	public void addOrder(Order o);

	public void updateOrder(Order o);

	public List<Order> listOrders();

	public Order getOrderById(int id);

	public void removeOrder(int id);
}
