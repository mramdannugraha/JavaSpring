package com.enigma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enigma.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAll();

	// select berdasarkan productName
	List<Product> findAllByProductNameLike(String productName);

	@Query("select p from Product p where p.productName like : productName")
	List<Product> getProductNameLike(@Param("productName") String productName);

	// select berdasarkan productId
	Product findAllByProductId(String productId);
	
	//Delete By Id
	Product findAllById(Integer id);

	@Query("select p from Product p where p.productId = :productId")
	Product getProductByProductId(@Param("productId") String productId);

	// select berdasarkan rentang harga
	List<Product> findAllByPriceBetween(Integer beginPrice, Integer endPrice);

	@Query("select p from Product p where p.price between :beginPrice and :endPrice")
	List<Product> getProductByIdProductId(@Param("beginPrice") Integer beginPrice, @Param("endPrice") Integer endPrice);

	
}
