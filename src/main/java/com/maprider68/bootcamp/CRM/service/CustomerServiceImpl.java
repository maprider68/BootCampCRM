package com.maprider68.bootcamp.CRM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maprider68.bootcamp.CRM.dao.CustomerDAO;
import com.maprider68.bootcamp.CRM.dao.CustomerRepository;
import com.maprider68.bootcamp.CRM.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	// Inject Customer DAO
	// Note: Qualifier is to indicate to use the JPA implementation bean
	@Autowired
	public CustomerServiceImpl(CustomerRepository pCustomerRepository)
	{
		customerRepository = pCustomerRepository;
	}	

	@Override
	public List<Customer> findAll() 
	{
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int pId) 
	{
		Optional<Customer> lFindById = customerRepository.findById(pId);
		
		Customer lCustomer = null;
		if (lFindById.isPresent())
		{
			lCustomer = lFindById.get();
		} else {
			throw new RuntimeException("Could not find customer by id - " + pId);
		}
		return lCustomer;
	}

	@Override
	public void save(Customer pCustomer) 
	{
		customerRepository.save(pCustomer);
	}

	@Override
	public void deleteById(int pId) 
	{
		customerRepository.deleteById(pId);
	}

}
