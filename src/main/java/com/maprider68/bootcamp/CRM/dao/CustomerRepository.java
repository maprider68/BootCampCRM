package com.maprider68.bootcamp.CRM.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maprider68.bootcamp.CRM.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
