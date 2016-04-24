package com.skbh.java;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/loginProcessor", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		System.out.println(loginDetails);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);
		loginService.registerUserService(loginDetails);
		model.addAttribute("serverTime", formattedDate);
		return "success";
	}

	@RequestMapping(value = "/registerProcessor", method = RequestMethod.POST)
	public String registerProcessor(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		System.out.println(loginDetails);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);
		loginService.registerUserService(loginDetails);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("successMessage", "Account has been created successfully,Please Login");
		return "login";
	}

}
