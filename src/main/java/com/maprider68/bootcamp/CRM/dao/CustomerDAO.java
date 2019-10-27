package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import com.maprider68.bootcamp.CRM.entity.Customer;

public interface CustomerDAO 
{

	public List<Customer> findAll();

}
