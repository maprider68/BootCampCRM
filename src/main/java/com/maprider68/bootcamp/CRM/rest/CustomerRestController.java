package com.maprider68.bootcamp.CRM.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maprider68.bootcamp.CRM.dao.CustomerDAO;
import com.maprider68.bootcamp.CRM.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
	private CustomerDAO customerDAO;
	
	// Inject Customer DAO
	@Autowired
	public CustomerRestController(CustomerDAO lCustomerDAO)
	{
		customerDAO = lCustomerDAO;
	}	
	
	// 	Expose "/customers" to return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll()
	{
		return customerDAO.findAll();
	}
 	
	
	
}
