package springmvc.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springmvc.java.dao.CategoryDAO;
import springmvc.java.domain.Category;
import springmvc.java.domain.Product;
import springmvc.java.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> findAllCategories() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryDAO.findAll();
	}

	@Override
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryDAO.findOne(id);
	}

	@Override
	public Category findCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDAO.findByCategoryName(categoryName);
	}

}
