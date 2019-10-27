package com.maprider68.bootcamp.CRM.dao;

import java.util.List;

import com.maprider68.bootcamp.CRM.entity.Customer;



//----------------------------------------------------------------------------------------------
//Deprecated: 
//	 We keep that as example of DAO implementation. 
//	 But, we end up using the JpaRepository which does not require us to provide an implementation
//   Thank you to Spring!
//----------------------------------------------------------------------------------------------



@Deprecated
public interface CustomerDAO 
{

	public List<Customer> findAll();

	public Customer findById(int pId);
	
	public void save(Customer pCustomer);
	
	public void deleteById(int pId);
	
}
