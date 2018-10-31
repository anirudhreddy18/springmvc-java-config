package springmvc.java.service;

import java.util.List;

import springmvc.java.domain.Category;
import springmvc.java.domain.Product;

public interface SearchService {

	List<Product> findProductsByProductName(String productName);
	
	//List<Product> findProductsByProductName(String categoryName, String productName);
}
