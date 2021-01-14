package com.enigma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	//SelectAll
	List<Category> findAll();
	
	//Select Berdasarkan Category
	List<Category> getListCategoryBycategoryNameLike(String categoryName);
	
	//Delete By Id
	Category findAllById(Integer id);
	
}
