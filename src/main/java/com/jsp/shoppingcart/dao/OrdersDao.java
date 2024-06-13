package com.jsp.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Orders;

@Repository
public class OrdersDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void saveOrders(Orders Orders)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(Orders);
		et.commit();
	}
	
	public void updateOrders(Orders Orders)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(Orders);
		et.commit();
	}

	public void deleteOrdersById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders Orders = em.find(Orders.class, id);
		
		et.begin();
		em.remove(Orders);
		et.commit();
	}
	
	public Orders findOrdersById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Orders Orders = em.find(Orders.class, id);
		if(Orders != null)
			return Orders;
		else 
			return null;
	}
}
