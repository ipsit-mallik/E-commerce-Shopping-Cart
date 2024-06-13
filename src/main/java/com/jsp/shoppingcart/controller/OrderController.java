package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.OrdersDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Orders;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class OrderController {

	@Autowired
	OrdersDao orderDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao prodDao;
	
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/buyItemInCart")
	public ModelAndView buyItemInCart()
	{
		Orders orders = new Orders();
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderObj",orders);
		mav.setViewName("OrderForm");
		return mav;
	}
	
	@RequestMapping("/saveOrder")
	public ModelAndView saveOrder(@ModelAttribute("orderObj")Orders order, HttpSession session)
	{
		Customer c = (Customer)session.getAttribute("customerinfo");
		Customer customer = customerDao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		List<Item> items = cart.getItems();
		
//		Storing the items whose quantity is less than the product stock.
		List<Item> itemList = new ArrayList<Item>();
		List<Item> itemWithGreaterQnt = new ArrayList<Item>();
		
		for(Item i:items)
		{
			Product p = prodDao.findProductById(i.getP_id());
			if(i.getQuantity()<p.getStock())
			{
				itemList.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				
				prodDao.updateProduct(p);
			}
			else
			{
				itemWithGreaterQnt.add(i);		
			}
		}
		order.setItems(itemList);
		
		double orderPrice = 0;
		for(Item i:itemList)
		{
			orderPrice = orderPrice + i.getPrice();
		}
		order.setTotal_price(orderPrice);
		cart.setItems(itemWithGreaterQnt);
		
		double totalprice = 0;
		for(Item i:itemWithGreaterQnt)
		{
			totalprice = totalprice + i.getPrice();
		}
		cart.setTotal_price(totalprice);
		
//		Storing the items in the order
		List<Orders> orders = customer.getOrders();
		if(orders.size()>0)
		{
			orders.add(order);
			customer.setOrders(orders);
		}
		else
		{
			List<Orders> orders1 = new ArrayList<Orders>();
			orders.add(order);
			customer.setOrders(orders1);
		}
		customer.setCart(cart);
		cartDao.updateCart(cart);
		orderDao.saveOrders(order);
		customerDao.updateCustomer(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Order Placed Successfully.");
		mav.addObject("orderDetail", order);
		mav.setViewName("CustomerBill");
		return mav;
	}
}
