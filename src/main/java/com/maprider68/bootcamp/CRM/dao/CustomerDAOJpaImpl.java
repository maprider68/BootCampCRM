package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maprider68.bootcamp.CRM.entity.Customer;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {
	
	// Field for EntityManager
	EntityManager entityManager;
	
	// Constructor injection
	@Autowired
	public CustomerDAOJpaImpl(EntityManager pEntityManager)
	{
		entityManager = pEntityManager;
	}

	@Override
	public List<Customer> findAll() 
	{
		// Create query
		Query lQuery = entityManager.createQuery("from customer");
		
		// Execute query
		List<Customer> lCustomers = lQuery.getResultList();

		return lCustomers;
	}

	@Override
	public Customer findById(int pId) 
	{
		// Create query
		Customer lCustomer = entityManager.find(Customer.class, pId);
		
		// Return result
		return lCustomer;
	}

	// Note: if pCustomer.id == 0, customer will be added, else it will update the existing customer with given id
	@Override
	public void save(Customer pCustomer) 
	{
		Customer lCustomer = entityManager.merge(pCustomer);
		
		pCustomer.setId(lCustomer.getId());
	}

	@Override
	public void deleteById(int pId) 
	{
		// Create query
		Query lQuery = entityManager.createQuery("delete from Customer where id = :customerId");
		lQuery.setParameter("customerId", pId);
		
		// Execute the delete
		lQuery.executeUpdate();		
	}

}
