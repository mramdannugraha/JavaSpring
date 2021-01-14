package com.enigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.CategoryService;
import com.enigma.model.Category;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/getListCategory")
	public ResponseEntity<Page<Category>> getListCategory(@RequestParam("page") Integer page, @RequestParam("pagesize") Integer pageSize){
		Page<Category> listCategory = categoryService.getListCategory(page, pageSize);
		return new ResponseEntity(listCategory, HttpStatus.OK);
	}
	
	@PostMapping("/createUpdateCategory")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		categoryService.createUpdateCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@GetMapping("/getListCategoryByName")
	public ResponseEntity<List<Category>> getCategoryByName(@RequestParam("categoryName") String categoryName){
		List<Category> listCategory = categoryService.getListCategoryByCategoryName(categoryName);
		return new ResponseEntity<List<Category>>(listCategory, HttpStatus.OK);
	}
	
	@GetMapping("/doDeleteCategory")
	public ResponseEntity<Integer> deleteCategory(@RequestParam Category categoryName){
		Integer result = categoryService.deleteCategory(categoryName.getId());
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
