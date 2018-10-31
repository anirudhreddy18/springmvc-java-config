package springmvc.java.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.Category;
import springmvc.java.domain.Product;
import springmvc.java.service.CategoryService;
import springmvc.java.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView retreiveProducts() {

		return new ModelAndView("/search");
	}

	@RequestMapping(value = "/displayProducts", method = RequestMethod.POST)
	public ModelAndView displayProducts(@RequestParam("productName") String productName, Model model) {

		List<Product> productsAfterSearch = searchService.findProductsByProductName(productName);

		model.addAttribute("productsAfterSearch", productsAfterSearch);
		model.addAttribute("isList", true);
		return new ModelAndView("/searchcontents");
	}
}
