package com.customermanagement.service;

import org.springframework.stereotype.Service;

import com.customermanagement.beans.CustomerCategoryRequestBean;
import com.customermanagement.beans.CustomerCategoryResponseBean;
import com.customermanagement.beans.CustomerRequestBean;
import com.customermanagement.beans.CustomerResponseBean;
import com.customermanagement.beans.CustomerTypeRequestBean;
import com.customermanagement.beans.CustomerTypeResponseBean;

@Service
public interface CRUDOperationsHandler{
	
	public CustomerResponseBean createCustomer(CustomerRequestBean _request);
	
	public CustomerResponseBean updateCustomer(CustomerRequestBean _request,String _customerDisplayId);
	
	public CustomerResponseBean removeCustomer(String _customerDisplayId);
	
	
	public CustomerCategoryResponseBean createCustomerCategory(CustomerCategoryRequestBean _request);
		
	public CustomerCategoryResponseBean removeCustomerCategory(Long _customerCategoryName);
	
	
	public CustomerTypeResponseBean createCustomerType(CustomerTypeRequestBean _request);
		
	public CustomerTypeResponseBean removeCustomerType(Long _customerTypeId);
	

}
