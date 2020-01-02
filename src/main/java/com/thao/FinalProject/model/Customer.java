package com.thao.FinalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "idCustomer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCustomer;
	@NotEmpty
	private String nameCustomer;

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

}
