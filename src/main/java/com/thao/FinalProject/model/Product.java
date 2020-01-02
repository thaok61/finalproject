package com.thao.FinalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "idProduct")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduct;
	@NotEmpty
	private String nameProduct;
	@NotNull
	private Integer idCategory;
	@NotNull
	private Integer quantity;
	@NotNull
	private Integer price;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product() {
		super();
	}

	public Product(Integer idProduct, String nameProduct, Integer idCategory, Integer quantity, Integer price,
			String description) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.idCategory = idCategory;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}

}
