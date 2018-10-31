package springmvc.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.Exception.ProductNotFoundException;
import springmvc.java.domain.Category;
import springmvc.java.domain.Product;
import springmvc.java.service.CategoryService;
import springmvc.java.service.ProductService;
import springmvc.java.service.SearchService;

public class SearchServiceImpl implements SearchService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public List<Product> findProductsByProductName(String productName) {

		List<Product> products = productService.getAllProducts();
		List<Product> productsAfterSearch = new ArrayList<>();
		for (Product product : products) {
			if (product.getProductName().contains(productName.toLowerCase())
					|| product.getProductDescription().contains(productName.toLowerCase())) {
				productsAfterSearch.add(product);
			}
		}

		if (productsAfterSearch.isEmpty()) {
			throw new ProductNotFoundException("No Product Found");
		}

		return productsAfterSearch;
	}

}
