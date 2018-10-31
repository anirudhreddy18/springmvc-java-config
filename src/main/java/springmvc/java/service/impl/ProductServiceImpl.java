package springmvc.java.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.java.dao.ProductDAO;
import springmvc.java.domain.Product;
import springmvc.java.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() {

		return (List<Product>) productDAO.findAll();
	}

	@Override
	public Product findProduct(Long productId) {

		return productDAO.findOne(productId);
	}

	@Override
	public List<Product> findAllProductsByCategoryId(Long categoryId) {
		
		return productDAO.findProductsByCategoryId(categoryId);
		
	}

	@Override
	public Product findProduct(Long categoryId, Long productId) {
		// TODO Auto-generated method stub
		return productDAO.findProductByCategoryAndproductId(categoryId, productId);
	}

}
