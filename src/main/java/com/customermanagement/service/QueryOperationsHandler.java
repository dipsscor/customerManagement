package com.customermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customermanagement.model.Customer;
import com.customermanagement.model.CustomerCategory;
import com.customermanagement.model.CustomerType;

@Service
public interface QueryOperationsHandler{
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerByDisplayId(String _customerDisplayId);
	
	public List<Customer> searchCustomers(String _customerDisplayId,String _customerName);
	
	public List<CustomerCategory> getAllCustomerCategories();
	
	public List<CustomerType> getAllCustomerTypes();

}
