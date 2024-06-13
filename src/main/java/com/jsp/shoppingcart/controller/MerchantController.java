package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.MerchantDao;
import com.jsp.shoppingcart.dto.Merchant;

@Controller
public class MerchantController {

	@Autowired
	MerchantDao md;
	
	@RequestMapping("/addMerchant")
	public ModelAndView addMerchant()
	{
		Merchant m = new Merchant();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("merchantobj", m);
		mav.setViewName("MerchantForm");
		return mav;
	}
	
	@RequestMapping("/saveMerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj")Merchant m)
	{
		md.saveMerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Data Saved Successfully.");
		mav.setViewName("MerchantMenu");
		return mav;
	}
	
	@RequestMapping("/merchantloginvalidation")
	public ModelAndView login(ServletRequest req, HttpSession session)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Merchant m = md.login(email, password);
		ModelAndView mav = new ModelAndView();
		if(m!=null)
		{
			mav.addObject("msg", "Successfully logged in.");
			mav.setViewName("MerchantOptions");
			session.setAttribute("merchantinfo", m);
			return mav;
		}
		else
		{
			mav.addObject("msg", "Invalid credentials!!");
			mav.setViewName("MerchantloginForm");
			return mav;
		}
	}
}
