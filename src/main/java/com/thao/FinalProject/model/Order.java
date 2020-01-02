package com.thao.FinalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "idOrder")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrder;
	private String date;
	private Integer idCustomer;
	private Integer totalMoney;


	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

}
