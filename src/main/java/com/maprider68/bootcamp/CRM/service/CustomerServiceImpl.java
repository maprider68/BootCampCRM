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

// Customer service implementation
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	// Inject Customer DAO
	@Autowired
	public CustomerServiceImpl(CustomerRepository pCustomerRepository)
	{
		customerRepository = pCustomerRepository;
	}	

	// Get list of all Customer
	@Override
	public List<Customer> findAll() 
	{
		return customerRepository.findAll();
	}

	// Find a Customer for a given id
	@Override
	public Customer findById(int pId) 
	{
		Optional<Customer> lFindById = customerRepository.findById(pId);
		
		Customer lCustomer = null;
		if (lFindById.isPresent())
		{
			// Customer found, get data
			lCustomer = lFindById.get();
		} else {
			// Customer not found for the given id, throw error
			throw new RuntimeException("Could not find customer by id - " + pId);
		}
		return lCustomer;
	}

	// Save a Customer
	@Override
	public void save(Customer pCustomer) 
	{
		// Validate that Mandatory field are present. If not, throw exception
		if (pCustomer.getCustomerNumber() == null || pCustomer.getCustomerNumber().isEmpty() ||
			pCustomer.getFirstName() == null || pCustomer.getFirstName().isEmpty() ||
			pCustomer.getLastName() == null || pCustomer.getLastName().isEmpty()||
			pCustomer.getTelephone() == null || pCustomer.getTelephone().isEmpty())
		{
			throw new RuntimeException("Customer mandatory fields[customerNumber,firstName,lastName,telephone] not provided.");
		}

		customerRepository.save(pCustomer);
	}

	// Delete a Customer for a given id
	@Override
	public void deleteById(int pId) 
	{
		customerRepository.deleteById(pId);
	}

}
