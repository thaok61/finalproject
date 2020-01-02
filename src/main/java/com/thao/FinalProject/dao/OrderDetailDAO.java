package com.thao.FinalProject.dao;

import java.util.List;

import com.thao.FinalProject.model.OrderDetail;

public interface OrderDetailDAO {
	public void addOrderDetail(OrderDetail o);

	public void updateOrderDetail(OrderDetail o);

	public List<OrderDetail> listOrderDetails();

	public OrderDetail getOrderDetailById(int id);

	public void removeOrderDetail(int id);
}
