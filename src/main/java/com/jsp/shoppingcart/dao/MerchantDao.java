package com.jsp.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Repository
public class MerchantDao {

	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ProductDao pd;
	
	public void saveMerchant(Merchant merchant)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(merchant);
		et.commit();
	}
	
	public Merchant login(String email,String pass)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pass);
		try {
			Merchant merchant = (Merchant) query.getSingleResult();
			return merchant;
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public void updateMerchant(Merchant merchant)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(merchant);
		et.commit();
	}

	public void deleteMerchant(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Merchant merchant = em.find(Merchant.class, id);
		
		et.begin();
		em.remove(merchant);
		et.commit();
	}
	
	public Merchant findMerchantById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Merchant merchant = em.find(Merchant.class, id);
		if(merchant != null)
			return merchant;
		else 
			return null;
	}
	
	public Merchant deleteProductFromMerchant(int merchant_id, int product_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Merchant merchant = em.find(Merchant.class, merchant_id);
		List<Product> products = merchant.getProducts();
		
		List<Product> productList = new ArrayList<Product>();
		for(Product p: products)
		{
			if(p.getId()!=product_id)
				productList.add(p);
		}
		merchant.setProducts(productList);
		
		return merchant;
//		Product p = pd.findProductById(product_id);
//		
//		products.remove(p);
//		
//		merchant.setProducts(products);
		
//		products = products.stream().filter(product->product.getId()!=product_id).collect(Collectors.toList());
//		merchant.setProducts(products);
		
	}
}
