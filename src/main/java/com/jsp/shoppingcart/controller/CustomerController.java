package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Merchant;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao cd;
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer()
	{
		Customer customer = new Customer();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj", customer);
		mav.setViewName("CustomerForm");
		return mav;
	}
	
	@RequestMapping("/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj")Customer c)
	{
		cd.saveCustomer(c);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Registered Successfully.");
		mav.setViewName("CustomerloginForm");
		return mav;
	}
	
	@RequestMapping("/customerloginvalidation")
	public ModelAndView loginCustomer(ServletRequest req, HttpSession session)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Customer c = cd.login(email, password);
		ModelAndView mav = new ModelAndView();
		if(c!=null)
		{
			mav.addObject("msg", "Successfully logged in.");
			mav.setViewName("CustomerOptions");
			session.setAttribute("customerinfo", c);
			return mav;
		}
		else
		{
			mav.addObject("msg", "Invalid credentials!!");
			mav.setViewName("CustomerloginForm");
			return mav;
		}
	}
}
