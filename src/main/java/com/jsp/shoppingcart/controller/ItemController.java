package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.ItemDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ItemController {

	@Autowired
	ItemDao itemDao;
	
	@Autowired
	ProductDao prodDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/addItem")
	public ModelAndView addItem(@RequestParam("id")int id)
	{
		Product product = prodDao.findProductById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productObj", product);
		mav.setViewName("ItemForm");
		return mav;
	}
	
	@RequestMapping("/addItemToCart")
	public ModelAndView addItemToCart(ServletRequest req, HttpSession session)
	{
		int pid = Integer.parseInt(req.getParameter("id"));
		String brand = req.getParameter("brand");
		String model = req.getParameter("model");
		String category = req.getParameter("category");
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		Item item = new Item();
		item.setP_id(pid);
		item.setBrand(brand);
		item.setModel(model);
		item.setCategory(category);
		item.setQuantity(quantity);
		item.setPrice(price*quantity);
		
		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart c = customer.getCart();
		
		// customer adding item to cart for first time
		if(c==null) 
		{ 
			Cart cart = new Cart();
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			
			cart.setItems(items);
			cart.setName(customer.getName());
			cart.setTotal_price(item.getPrice());
			
			customer.setCart(cart);
			
			itemDao.saveItem(item);
			cartDao.saveCart(cart);
			customerDao.updateCustomer(customer);
		}
		else {
			List<Item> items = c.getItems();
			if(items.size()>0)
			{
				items.add(item);
				c.setItems(items);
				double totalPrice = 0;
				for(Item i : items) totalPrice += i.getPrice();
				c.setTotal_price(totalPrice);
				customer.setCart(c);
				
				itemDao.saveItem(item);
				cartDao.updateCart(c);
				customerDao.updateCustomer(customer);
			}
			else 
			{
				List<Item> itemList = new ArrayList<Item>();
				itemList.add(item);
				c.setItems(itemList);
				c.setTotal_price(item.getPrice());
				
				itemDao.saveItem(item);
				cartDao.updateCart(c);
				customerDao.updateCustomer(customer);
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://displayAllProduct");
		return mav;
	}
}
