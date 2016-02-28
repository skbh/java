package com.skbh.spring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerTest {
	
	//public ModelAndView ownController(@PathVariable("userName") String name, @PathVariable("password") String password ){
	@RequestMapping(value="/welcomes/{userName}/{password}")
	public ModelAndView ownController(@PathVariable Map<String,String> pathvar){
		String name=pathvar.get("userName");
		String password=pathvar.get("password");		
		ModelAndView modelAndView=new ModelAndView("index");
		modelAndView.addObject("message", "meggase by own controller :" + name + " Password is " + password);
		return modelAndView;
		
	}
	
	@RequestMapping(value="/hello")
	public ModelAndView Hello(){
		ModelAndView modelAndView=new ModelAndView("index");
		modelAndView.addObject("message", "Hello meggase by Hello controller");
		return modelAndView;
		
	}
	

}
