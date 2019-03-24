package com.customermanagement.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.customermanagement.beans.CustomerRequestBean;
import com.customermanagement.repository.CustomerCategoryRepository;
import com.customermanagement.repository.CustomerTypeRepository;

@Service
public class CustomerRequestBeanValidator implements Validator{
	
	
	@Autowired
	private CustomerCategoryRepository customerCategoryRepository;
	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerRequestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors _errors) {
		CustomerRequestBean customerRequestBeanRequest = (CustomerRequestBean) target;
		
		if(customerCategoryRepository.findByCustomerCategoryNameIgnoreCase(customerRequestBeanRequest.getCustomerCategory())==null){
			_errors.reject("CUSTOMER CATEGORY INVALID","PLEASE REFER API FOR VALUES");
		}
		
		if(customerTypeRepository.findByCustomerTypeNameIgnoreCase(customerRequestBeanRequest.getCustomerType())==null){
			_errors.reject("CUSTOMER TYPE INVALID","PLEASE REFER API FOR VALUES");
		}
		if(!customerRequestBeanRequest.getEmailAddress().contains("@")){
			_errors.reject("EMAIL ADDRESS INVALID","PLEASE PROVIDE VALID EMAIL ADDRESS");
		}

	
	}

}
