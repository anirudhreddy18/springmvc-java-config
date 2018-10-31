package springmvc.java.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.User;
import springmvc.java.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private ServletContext context;

	@RequestMapping(value = "/users", params = "register", method = RequestMethod.GET)
	public ModelAndView displayRegistrationPage(Model model) {

		model.addAttribute("user", new User());
		String url = context.getContextPath() + "/users";
		model.addAttribute("url", url);
		return new ModelAndView("/user/register");
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ModelAndView saveuser(// @RequestParam("userId") String userId, @RequestParam("firstName") String
			// firstName,
			// @RequestParam("lastName") String lastName, @RequestParam("password") String
			// password,
			// @RequestParam("phoneNumber") String phoneNumber, @RequestParam("email")
			// String email)
			@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		// @RequestBody @Valid User user, BindingResult result, Model model) {
		// User user = new User();
		// user.setUserId(userId);
		// user.setFirstName(firstName);
		// user.setLastName(lastName);
		// user.setPassword(password);
		// user.setEmail(email);
		// user.setPhoneNumber(phoneNumber);

		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return new ModelAndView("/user/register");
		} else {
			userService.saveUser(user);
			return new ModelAndView("redirect:/users?login");
		}

	}

	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("userId") String userId, Model model) {

		User user = userService.findUser(userId);
		model.addAttribute("user", user);

		return new ModelAndView("/user/userdetails");
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return new ModelAndView("/user/userdetails");
		} else {
			userService.saveUser(user);
			return new ModelAndView("/user/success");
		}

	}

}
