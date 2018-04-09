package com.dkd.shop1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {

	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("isUserClickHome",true);
		return mv;
	}
	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Login");
		mv.addObject("isUserClickLogin",true);
		return mv;
	}
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Register");
		mv.addObject("isUserClickRegister",true);
		return mv;
	}
	@RequestMapping(value="/about")
	public ModelAndView aboutus()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("isUserClickAboutUs",true);
		return mv;
	}
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("isUserClickContactUs",true);
		return mv;
	}
	@RequestMapping(value="/viewproducts")
	public ModelAndView viewproducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","View Products");
		mv.addObject("isUserClickViewProducts",true);
		return mv;
	}

}
