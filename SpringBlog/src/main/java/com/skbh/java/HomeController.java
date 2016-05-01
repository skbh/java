package com.skbh.java;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skbh.java.model.LoginDetails;
import com.skbh.java.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@ModelAttribute
	public void commonMessage(Model model) {
		model.addAttribute("headermessage", "Java blog - spring - hibernate - restful");

	}

	@RequestMapping(value = "/admin/signin", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/admin/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView view = new ModelAndView("register");
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("IN", "India");
		country.put("AU", "Australia");
		country.put("US", "USA");
		country.put("CA", "Canada");
		country.put("SR", "Sri Lanka");
		country.put("UK", "United Kindom");

		view.addObject("loginDetails", new LoginDetails());
		view.addObject("country", country);
		return view;
	}

	@RequestMapping(value = "/admin/loginProcessor", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		System.out.println(loginDetails);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);
		loginService.registerUserService(loginDetails);
		model.addAttribute("serverTime", formattedDate);
		return "success";
	}

	@RequestMapping(value = "/admin/registerProcessor", method = RequestMethod.POST)
	public ModelAndView registerProcessor(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		System.out.println(loginDetails);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);
		loginService.registerUserService(loginDetails);
		ModelAndView register = new ModelAndView("login");
		register.addObject("serverTime", formattedDate);
		register.addObject("successMessage", "Account has been created successfully,Please Login");
		return register;
	}

	@RequestMapping("/logout")
	public ModelAndView showLoggedout() {
		ModelAndView logout = new ModelAndView("redirect:/admin/signin");
		logout.addObject("logoutMessage", "You have been logged out.");
		return logout;
	}

}
