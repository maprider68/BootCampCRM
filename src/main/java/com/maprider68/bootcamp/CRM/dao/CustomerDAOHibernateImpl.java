package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maprider68.bootcamp.CRM.entity.Customer;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

	// Field for EntityManager
	EntityManager entityManager;
	
	// Constructor injection
	@Autowired
	public CustomerDAOHibernateImpl(EntityManager pEntityManager)
	{
		entityManager = pEntityManager;
	}
	
	@Override
	@Transactional
	public List<Customer> findAll() 
	{
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create query
		Query<Customer> lQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// Execute query
		List<Customer> lCustomers = lQuery.getResultList();
		
		// Return result
		return lCustomers;
	}

}
