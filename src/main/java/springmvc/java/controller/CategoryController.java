package springmvc.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.TO.CategoryTO;
import springmvc.java.domain.Category;
import springmvc.java.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ModelAndView findAllCategories(Model model)
	{
		boolean isList = true;
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("isList", isList);
		return new ModelAndView("/categories");
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = "application/json")
	public Category findAllCategories(@PathVariable("id") Long id , Model model)
	{
		Category category = categoryService.findCategoryById(id);
		//model.addAttribute("category", category);
		//return new ModelAndView("/categories");
		return category;
	}
	
	//@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
	public ModelAndView findAllCategories(@PathVariable("categoryName") String categoryName , Model model)
	{
		Category category = categoryService.findCategoryByName(categoryName);
		model.addAttribute("category", category);
		return new ModelAndView("/categories");
	}
	
}
