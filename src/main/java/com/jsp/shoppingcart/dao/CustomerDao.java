package com.jsp.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Customer;

@Repository
public class CustomerDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void saveCustomer(Customer customer)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(customer);
		et.commit();
	}
	
	public Customer login(String email,String pass)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Customer m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pass);
		try {
			Customer customer  = (Customer) query.getSingleResult();
			return customer;
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public void updateCustomer(Customer customer)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(customer);
		et.commit();
	}

	public void deleteCustomer(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, id);
		
		et.begin();
		em.remove(customer);
		et.commit();
	}
	
	public Customer findCustomerById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		if(customer != null)
			return customer;
		else 
			return null;
	}
}
