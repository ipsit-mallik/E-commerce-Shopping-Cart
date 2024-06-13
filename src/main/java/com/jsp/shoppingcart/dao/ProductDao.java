package com.jsp.shoppingcart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void saveProduct(Product Product)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(Product);
		et.commit();
	}
	
	public void updateProduct(Product Product)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(Product);
		et.commit();
	}

	public void deleteProductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product Product = em.find(Product.class, id);
		
		et.begin();
		em.remove(Product);
		et.commit();
	}
	
	public Product findProductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Product Product = em.find(Product.class, id);
		if(Product != null)
			return Product;
		else 
			return null;
	}
	
	public List<Product> fetchAllProducts()
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Product c");
		return query.getResultList();
	}

	public List<Product> findProductByBrand(String brand)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.brand=?1");
		query.setParameter(1, brand);
		return query.getResultList();
	}
	
	public List<Product> findProductByCategory(String category)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.category=?1");
		query.setParameter(1, category);
		return query.getResultList();
	}
	
	public List<Product> findProductByRange(double low, double high)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.price between ?1 and ?2");
		query.setParameter(1, low);
		query.setParameter(2, high);
		return query.getResultList();
	}
}
