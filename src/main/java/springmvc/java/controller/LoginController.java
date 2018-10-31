package springmvc.java.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.User;
import springmvc.java.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private ServletContext context;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/users", params = "login", method = RequestMethod.GET)

	public ModelAndView displayLoginPage(Model model) {
		String url = context.getContextPath() + "/checkLogin";
		model.addAttribute("url", url);
		return new ModelAndView("/user/login");
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkForValidUser(@RequestParam("username") String userId,
			@RequestParam("password") String password, HttpSession session) {

		User user = loginService.findUser(userId);

		if (user.getPassword().equals(password)) {

			session.setAttribute("userId", user.getUserId());
			ModelAndView mv = new ModelAndView("redirect:/products");
			return mv;

		}

		return new ModelAndView("/user/login", "loginError", "InValid Username And Password");

	}

	@RequestMapping(value = "/users", params = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("userId");
		return new ModelAndView("/user/login");
	}

}
