package springmvc.java.service;

import java.util.List;

import springmvc.java.domain.Product;

public interface ProductService {

	List<Product> findAllProductsByCategoryId(Long categoryId);
	
	List<Product> getAllProducts();

	Product findProduct(Long productId);
	
	Product findProduct(Long categoryId ,Long productId);
}
