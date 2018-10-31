package springmvc.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.Category;
import springmvc.java.domain.Product;
import springmvc.java.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	private boolean isList;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView findAllCategories(Model model)
	{
		isList = true;
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("isList", isList);
		return new ModelAndView("/products");
		
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ModelAndView findAllCategories(@PathVariable("id") Long id , Model model)
	{
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return new ModelAndView("/products");
	}
	
	@RequestMapping(value = "/categories/{categoryId}/products", method=RequestMethod.GET)
	public ModelAndView findAllProductsByCategoryId(@PathVariable("categoryId") Long categoryId, Model model)
	{
		List<Product> products = productService.findAllProductsByCategoryId(categoryId);
		model.addAttribute("products", products);
		isList = true;
		model.addAttribute("isList", isList);
		return new ModelAndView("/products");
		
	}
	
	@RequestMapping(value = "/categories/{categoryId}/products/{productId}", method=RequestMethod.GET)
	public ModelAndView findProductByCategoryIdAndProductId(@PathVariable("categoryId") Long categoryId, @PathVariable("productId") Long productId, Model model)
	{
		Product product = productService.findProduct(categoryId, productId);
		model.addAttribute("product", product);
		
		return new ModelAndView("/products");
		
	}
}
