package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maprider68.bootcamp.CRM.entity.Customer;




// ----------------------------------------------------------------------------------------------
// Deprecated: 
// 	 We keep that as example of DAO implementation. 
//	 But, we end up using the JpaRepository which does not require us to provide an implementation
//   Thank you to Spring!
//----------------------------------------------------------------------------------------------




@Deprecated
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

	@Override
	public Customer findById(int pId) 
	{
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create query
		Customer lCustomer = currentSession.get(Customer.class, pId);
		
		// Return result
		return lCustomer;
	}

	@Override
	public void save(Customer pCustomer) 
	{
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Save customer 
		// Note: if pCustomer.id == 0, customer will be added, else it will update the existing customer with given id
		currentSession.saveOrUpdate(pCustomer);
	}

	@Override
	public void deleteById(int pId) 
	{
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete customer
		Query lQuery = currentSession.createQuery("delete from Customer where id = :customerId");
		lQuery.setParameter("customerId", pId);
		lQuery.executeUpdate();		
	}

}
