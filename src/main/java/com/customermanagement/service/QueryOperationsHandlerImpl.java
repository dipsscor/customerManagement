package com.customermanagement.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanagement.model.Customer;
import com.customermanagement.model.CustomerCategory;
import com.customermanagement.model.CustomerType;
import com.customermanagement.repository.CustomerCategoryRepository;
import com.customermanagement.repository.CustomerRepository;
import com.customermanagement.repository.CustomerTypeRepository;


@Service
public class QueryOperationsHandlerImpl implements QueryOperationsHandler{
	private static final Logger logger = Logger.getLogger(QueryOperationsHandlerImpl.class.getName());
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerCategoryRepository customerCategoryRepository;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	/**
	 * *********** CUSTOMER******************
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@Override
	public Customer getCustomerByDisplayId(String _customerDisplayId) {
		return customerRepository.findByCustomerDisplayIdIgnoreCase(_customerDisplayId);
	}
	
	@Override
	public List<Customer> searchCustomers(String _customerDisplayId,
			String _customerName) {
		return customerRepository.findByCustomerDisplayIdOrCustomerNameContainingIgnoreCase(_customerDisplayId, _customerName);
	}


	
	/**
	 * *********** CUSTOMER CATEGORY******************
	 */
	@Override
	public List<CustomerCategory> getAllCustomerCategories() {
		return customerCategoryRepository.findAll();
	}


	
	/**
	 * *********** CUSTOMER TYPE******************
	 */
	@Override
	public List<CustomerType> getAllCustomerTypes() {
		return customerTypeRepository.findAll();
	}



	
	
}
