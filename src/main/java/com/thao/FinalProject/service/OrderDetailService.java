package com.thao.FinalProject.service;

import java.util.List;

import com.thao.FinalProject.model.OrderDetail;

public interface OrderDetailService {
	public void addOrderDetail(OrderDetail o);

	public void updateOrderDetail(OrderDetail o);

	public List<OrderDetail> listOrderDetails();

	public OrderDetail getOrderDetailById(int id);

	public void removeOrderDetail(int id);
}
