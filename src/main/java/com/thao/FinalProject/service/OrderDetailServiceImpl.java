package com.thao.FinalProject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.thao.FinalProject.dao.OrderDetailDAO;
import com.thao.FinalProject.model.OrderDetail;

public class OrderDetailServiceImpl implements OrderDetailService{
	private OrderDetailDAO orderDetailDAO;

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	@Override
	@Transactional
	public void addOrderDetail(OrderDetail o) {
		this.orderDetailDAO.addOrderDetail(o);
	}

	@Override
	@Transactional
	public void updateOrderDetail(OrderDetail o) {
		this.orderDetailDAO.updateOrderDetail(o);
	}

	@Override
	@Transactional
	public List<OrderDetail> listOrderDetails() {
		return this.orderDetailDAO.listOrderDetails();
	}

	@Override
	@Transactional
	public OrderDetail getOrderDetailById(int id) {
		return this.orderDetailDAO.getOrderDetailById(id);
	}

	@Override
	@Transactional
	public void removeOrderDetail(int id) {
		this.orderDetailDAO.removeOrderDetail(id);
	}
}
