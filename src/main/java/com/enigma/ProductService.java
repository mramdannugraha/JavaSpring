package com.enigma;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.model.Product;
import com.enigma.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

//	public List<Product> doProduct(Integer page, Integer pagesize) {
//		return productRepository.findAll();
//	}

	public Page<Product> getListProduct(int page, int pagesize) {
		Pageable paging = PageRequest.of(page, pagesize);
		return productRepository.findAll(paging);
	}

	public Product getProductById(String productId) {
		return productRepository.findAllByProductId(productId);
	}

	public List<Product> getListProductByName(String productName) {
		return productRepository.findAllByProductNameLike("%" + productName + "%");
	}

	public List<Product> getListProductByPrice(Integer beginPrice, Integer endPrice) {
		return productRepository.findAllByPriceBetween(beginPrice, endPrice);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Integer deleteProduct(int id) {
		try {
			Product product = productRepository.findAllById(id);
			productRepository.delete(product);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
