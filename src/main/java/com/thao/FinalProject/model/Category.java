package com.thao.FinalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "idCategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;
	@NotEmpty
	public String nameCategory;

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	
	public Integer getIdCategory() {
		return idCategory;
	}
	
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}

	public Category() {
		super();
	}

	public Category(Integer id, String name) {
		super();
		this.idCategory = id;
		this.nameCategory = name;
	}

}
