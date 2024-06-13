package com.jsp.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Item;

@Repository
public class ItemDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void saveItem(Item Item)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(Item);
		et.commit();
	}
	
	public void updateItem(Item Item)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(Item);
		et.commit();
	}

	public void deleteItemById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Item Item = em.find(Item.class, id);
		
		et.begin();
		em.remove(Item);
		et.commit();
	}
	
	public Item findItemById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Item Item = em.find(Item.class, id);
		if(Item != null)
			return Item;
		else 
			return null;
	}
}
