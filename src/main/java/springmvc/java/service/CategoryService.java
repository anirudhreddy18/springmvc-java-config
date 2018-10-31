package springmvc.java.service;

import java.util.List;

import springmvc.java.domain.Category;
import springmvc.java.domain.Product;

public interface CategoryService {

	List<Category> findAllCategories();

	Category findCategoryById(Long id);
	
	Category findCategoryByName(String categoryName);
}
