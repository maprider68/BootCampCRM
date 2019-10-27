package com.maprider68.bootcamp.CRM.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maprider68.bootcamp.CRM.dao.CustomerDAO;
import com.maprider68.bootcamp.CRM.entity.Customer;
import com.maprider68.bootcamp.CRM.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
	private CustomerService customerService;
	
	// Inject Customer DAO
	@Autowired
	public CustomerRestController(CustomerService lCustomerService)
	{
		customerService = lCustomerService;
	}	
	
	// 	Expose "/customers" to return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll()
	{
		return customerService.findAll();
	}

	// Get customer information for a given id
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId)
	{
		Customer lCustomer = customerService.findById(customerId);
		
		// Throw exception if the customer is not found
		if (lCustomer == null)
		{
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		return lCustomer;
	}
	
	// Add a customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer pCustomer)
	{
		// In case, an Id is pass, set it to 0 to signify we want to add
		pCustomer.setId(0);
		
		customerService.save(pCustomer);
		
		return pCustomer;
	}
	
	// Update a customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer pCustomer)
	{
		customerService.save(pCustomer);
		
		return pCustomer;
	}
		
	// Delete a customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		Customer lCustomer = customerService.findById(customerId);
		
		// Throw exception if the customer is not found
		if (lCustomer == null)
		{
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		customerService.deleteById(customerId);
		
		return "Deleted customer with id - " + customerId;
	}
	
}
