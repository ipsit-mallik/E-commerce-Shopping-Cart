package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.MerchantDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao prodDao;
	
	@Autowired
	MerchantDao merchantDao;
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct()
	{
		Product p = new Product();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("ProductForm");
		return mav;
	}
	
	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p, HttpSession session)
	{
		Merchant m = (Merchant)session.getAttribute("merchantinfo");
		List<Product> products = m.getProducts();
		if(products.size()>0) // if the merchant has already added product.
		{
			products.add(p);
			m.setProducts(products);
		}
		else // if the merchant is adding product for the first time.
		{
			List<Product> productlist = new ArrayList<Product>();
			productlist.add(p);
			m.setProducts(productlist);
		}
		
		prodDao.saveProduct(p);
		merchantDao.updateMerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Product added successfully.");
		mav.setViewName("MerchantOptions");
		return mav;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session)
	{
		Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
		Merchant m = merchantDao.deleteProductFromMerchant(merchant.getId(), id);
		
		merchantDao.updateMerchant(m);
		prodDao.deleteProductById(id);
		
		session.setAttribute("merchantinfo", m);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayProduct");
		return mav;
	}
	
	@RequestMapping("/displayAllProduct")
	public ModelAndView displayAllProducttoCustomer()
	{
		List<Product> products = prodDao.fetchAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("CustomerAllProductDisplay");
		return mav;
	}
	
	@RequestMapping("/displayProductbyBrand")
	public ModelAndView displayProductbyBrandtoCustomer(ServletRequest req)
	{
		String brand = req.getParameter("brand");
		List<Product> products = prodDao.findProductByBrand(brand);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("CustomerAllProductDisplay");
		return mav;
	}
	
	@RequestMapping("/displayProductbyCategory")
	public ModelAndView displayProductbyCategorytoCustomer(ServletRequest req)
	{
		String category = req.getParameter("category");
		List<Product> products = prodDao.findProductByCategory(category);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("CustomerAllProductDisplay");
		return mav;
	}
	
	@RequestMapping("/displayProductbyRange")
	public ModelAndView displayProductbyRange(@RequestParam("id")String s)
	{
		List<Product> products = new ArrayList<Product>();
		if(s.equals("below-500")) {
			products = prodDao.findProductByRange(0.0, 499.0);
		}
		else if(s.equals("500-1000")) {
			products = prodDao.findProductByRange(500.0, 1000.0);
		}
		else {
			products = prodDao.findProductByRange(1001.0, 100000.0);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("CustomerAllProductDisplay");
		return mav;
	}
	
	@RequestMapping("/updateProduct")
	public ModelAndView uprodDaoateProduct(@RequestParam("id")int id)
	{
		Product product = prodDao.findProductById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", product);
		mav.setViewName("ProductUpdateForm");
		return mav;
	}
	@RequestMapping("/updateProductData")
	public ModelAndView updateProductData(@ModelAttribute("productobj")Product p)
	{
		prodDao.updateProduct(p);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayProduct");
		return mav;
	}
}
