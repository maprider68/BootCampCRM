package com.maprider68.bootcamp.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maprider68.bootcamp.CRM.dao.CustomerDAO;
import com.maprider68.bootcamp.CRM.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	// Inject Customer DAO
	// Note: Qualifier is to indicate to use the JPA implementation bean
	@Autowired
	public CustomerServiceImpl(@Qualifier("customerDAOJpaImpl") CustomerDAO lCustomerDAO)
	{
		customerDAO = lCustomerDAO;
	}	

	@Override
	@Transactional
	public List<Customer> findAll() 
	{
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int pId) 
	{
		return customerDAO.findById(pId);
	}

	@Override
	@Transactional
	public void save(Customer pCustomer) 
	{
		customerDAO.save(pCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int pId) 
	{
		customerDAO.deleteById(pId);
	}

}
