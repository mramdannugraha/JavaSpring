package com.enigma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	private Integer id;
	@Column(name = "category_id")
	private String categoryId;
	@Column(name = "category_name")
	private String categoryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(Integer id, String categoryId, String categoryName) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category() {

	}
}
