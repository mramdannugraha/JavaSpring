package com.enigma.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.ProductService;
import com.enigma.model.Product;
import com.enigma.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/getListProduct")
	public ResponseEntity<Page<Product>> getListProduct(@RequestParam("page") Integer page, @RequestParam("pagesize") Integer pagesize){
		Page<Product> productList = productService.getListProduct(page, pagesize);
		return new ResponseEntity<> (productList, HttpStatus.OK);
	}
	
	
	
	
//	public ResponseEntity<List<Product>> getListProduct(
//			@CookieValue(value = "session", defaultValue = "no-cookie") String session) {
//		if (session.equals("no-cookie") == false) {
//
//			List<Product> product = productService.doProduct();
//			return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<List<Product>>(HttpStatus.UNAUTHORIZED);
//		}
//	}
	
	@GetMapping("/getListProductById")
	public ResponseEntity<Product> getProductById(@RequestParam("productId") String productId){
		Product product = productService.getProductById(productId);
		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	@GetMapping("/getListProductByName/{productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName){
		List<Product> productList = (List<Product>) productService.getListProductByName(productName);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@GetMapping("/getListProductByPrice")
	public ResponseEntity<List<Product>> getListProductByPrice(){
		Integer endPrice = 20000;
		Integer beginPrice = 10000;
		List<Product> productList = productService.getListProductByPrice(beginPrice, endPrice);
		return new ResponseEntity<>(productList, HttpStatus.OK);

	}
	
	@PostMapping("/updateProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity(product, HttpStatus.OK);
	}
		
	@GetMapping("/deleteProduct")
	public ResponseEntity<Integer> deleteProduct(@RequestBody Product product){
		Integer result = productService.deleteProduct(product.getId());
		return new ResponseEntity<>(result, HttpStatus.OK); 
	}
}
