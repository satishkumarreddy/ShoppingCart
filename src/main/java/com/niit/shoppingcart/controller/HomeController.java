package com.niit.shoppingcart.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Supplier;

@Controller
public class HomeController {
	@RequestMapping("/")	
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping("/home")	
	public ModelAndView homePage1()
	{
		
		
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
  
	
}
