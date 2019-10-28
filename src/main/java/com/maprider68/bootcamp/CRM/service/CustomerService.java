package com.maprider68.bootcamp.CRM.service;

import java.util.List;

import com.maprider68.bootcamp.CRM.entity.Customer;

// Customer service interface
public interface CustomerService 
{
	
	public List<Customer> findAll();

	public Customer findById(int pId);
	
	public void save(Customer pCustomer);
	
	public void deleteById(int pId);

}
