package com.customermanagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customermanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable>{
	
    public Customer findByCustomerName(String _customerName);
	
    public Customer findByCustomerDisplayIdIgnoreCase(String _customerDisplayId);
    
    public List<Customer> findByCustomerDisplayIdOrCustomerNameContainingIgnoreCase(String _customerDisplayId,String _customerName);

}
