package springmvc.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.Cart;
import springmvc.java.domain.Product;
import springmvc.java.domain.Purchase;
import springmvc.java.domain.User;
import springmvc.java.service.ProductService;

import springmvc.java.service.UserService;

@Controller
public class CartController {

	@Autowired
	private Cart cart;

	@Autowired
	private Purchase purchase;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/cart/add/{productId}", method = RequestMethod.GET)
	public ModelAndView addTocart(@PathVariable("productId") Long productId, HttpServletRequest request) {
		Product product = productService.findProduct(productId);
		cart.addProduct(product);
		String referer = request.getHeader("Referer");
		return new ModelAndView("redirect:" + referer);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView displayItemsInCart(Model model) {
		
		model.addAttribute("cart", cart);
		model.addAttribute("total", cart.totalCost());
		return new ModelAndView("/cart");
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView checkOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userService.findUser(userId);

		purchase.setItems(cart.getItems());
		purchase.setOrderId((long) (Math.random() * 10000));
		purchase.setTotalCost(cart.totalCost());
		purchase.setUser(user);

		cart.getItems().clear();
		return new ModelAndView("redirect:/cart");
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public ModelAndView purchase(Model model) {

		model.addAttribute("purchase", purchase);
		return new ModelAndView("/purchase");
	}
}
