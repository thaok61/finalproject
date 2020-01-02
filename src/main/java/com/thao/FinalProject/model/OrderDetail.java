package com.thao.FinalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@Column(name = "idOrderDetail")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrderDetail;
	private Integer idOrder;
	private Integer idProduct;
	private Integer quantity;

	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

}
