package com.jsp.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.ItemDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ItemDao itemDao;
	
	@RequestMapping("/fetchItemofCart")
	public ModelAndView fetchItemofCart(HttpSession session)
	{
		Customer c = (Customer) session.getAttribute("customerinfo"); 
		Customer customer = customerDao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		if(cart!=null) {
			List<Item> items = cart.getItems();
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("itemList",items);
			mav.addObject("totalPrice",cart.getTotal_price());
			mav.setViewName("CustomerCartItemDisplay");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("itemList",null);
			mav.addObject("totalPrice",0.0);
			mav.setViewName("CustomerCartItemDisplay");
			return mav;
		}
	}
	
	@RequestMapping("/removeItemfromCart")
	public ModelAndView removeItemfromCart()
	{
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping("/removeAllItemFromCart")
	public ModelAndView removeAllItemFromCart(HttpSession session)
	{
		Customer c = (Customer) session.getAttribute("customerinfo"); 
		Customer customer = customerDao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		List<Item> items = cart.getItems();
		
		Cart cart2 = cartDao.removeAllItemsFromCart(cart.getId());
		for(Item i:items )
		{
			itemDao.deleteItemById(i.getId());
		}
		
		customer.setCart(cart2);
		customerDao.updateCustomer(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList",null);
		mav.addObject("totalPrice",0.0);
		mav.setViewName("redirect://fetchItemofCart");
		return mav;
	}
}
