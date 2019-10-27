package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import com.maprider68.bootcamp.CRM.entity.Customer;

public interface CustomerDAO 
{

	public List<Customer> findAll();

	public Customer findById(int pId);
	
	public void save(Customer pCustomer);
	
	public void deleteById(int pId);
	
}
