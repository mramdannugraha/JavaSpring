package com.enigma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.model.Category;
import com.enigma.model.Toko;
import com.enigma.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public Page<Category> getListCategory(int page, int pagesize){
		Pageable paging = PageRequest.of(page, pagesize);
		return categoryRepository.findAll(paging);
	}
	
	public Category createUpdateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getListCategoryByCategoryName(String categoryName){
		return categoryRepository.getListCategoryBycategoryNameLike(categoryName);
	}
	
	public Integer deleteCategory(int id) {
		try {
			Category category = categoryRepository.findAllById(id);
			categoryRepository.delete(category);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
