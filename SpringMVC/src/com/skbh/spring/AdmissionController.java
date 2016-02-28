package com.skbh.spring;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skbh.model.AjaxModel;
import com.skbh.model.Employee;
import com.skbh.model.Student;

@Controller
public class AdmissionController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		// modelAndView.addObject("headermessage", "www.skbh.in");
		return modelAndView;
	}

	@ModelAttribute
	public void commonMessage(Model model) {
		model.addAttribute("headermessage", "www.skbh.in");

	}

	@ModelAttribute("student_Model")
	public Student getstudent_Model() {
		return new Student();
	}

	@RequestMapping(value = "/submitform.Spring", method = RequestMethod.POST)
	public ModelAndView submitForm(@Valid @ModelAttribute("student_Model") Student student, BindingResult results) {

		if (results.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AdmissionForm");
			return modelAndView;
		}

		ModelAndView modelAndView = new ModelAndView("success");
		return modelAndView;

		// modelAndView.addObject("headermessage", "www.skbh.in");
		// modelAndView.addObject("message", "your detail are : " + studentName
		// + " " + course + "" + country);
		// modelAndView.addObject("student_Model", student);//no need to write
		// spring take cares of it

	}

	// public ModelAndView submitForm(@RequestParam("studentName") String
	// studentName, @RequestParam("course") String course){
	// public ModelAndView submitForm(@RequestParam Map<String,String> param){
	//
	// Student student= new Student();
	// student.setStudentName(param.get("studentName"));
	// student.setCourse(param.get("course"));
	// student.setCountry(param.get("country"));

	@RequestMapping(value = "/url", method = RequestMethod.GET)
	public ModelAndView getProfile() {
		ModelAndView modelAndView = new ModelAndView("ajexcall");
		// modelAndView.addObject("headermessage", "www.skbh.in");
		return modelAndView;
	}

	@RequestMapping(value = "/url", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Employee add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Employee employee = new Employee();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		employee.setEmail(email);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);

		return employee;
	}

	@ModelAttribute("ajaxModel")
	public AjaxModel getajaxModel() {
		return new AjaxModel();
	}

	@RequestMapping(value = "/ajexurl", method = RequestMethod.POST)
	public @ResponseBody String makeAjexCall(@RequestBody AjaxModel ajaxModel) {
		System.out.println("data : " + ajaxModel.getT1() + " #  " + ajaxModel.getT2());
		return "Hello " + new Date() + ajaxModel.getT1() + ajaxModel.getT2();

	}

	/*
	 * @RequestMapping(value = "/ajexurl", method = RequestMethod.POST)
	 * public @ResponseBody String makeAjexCall(@ModelAttribute("ajaxModel")
	 * AjaxModel ajaxModel) { System.out.println("data : " + ajaxModel.getT1() +
	 * " #  " + ajaxModel.getT2()); return "Hello " + new Date() +
	 * ajaxModel.getT1() + ajaxModel.getT2(); }
	 */

	@RequestMapping(value = "/random", method = RequestMethod.POST)
	public @ResponseBody String getRandomAjexCall() {
		return "Hello " + new Date();
	}
}
