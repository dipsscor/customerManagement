package com.customermanagement.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.customermanagement.beans.CustomerCategoryRequestBean;
import com.customermanagement.repository.CustomerCategoryRepository;
@Service
public class CustomerCategoryRequestBeanValidator implements Validator{
	@Autowired
	private CustomerCategoryRepository customerCategoryRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerCategoryRequestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors _errors) {
		CustomerCategoryRequestBean customerCategoryRequestBeanRequest = (CustomerCategoryRequestBean) target;
		
		if(customerCategoryRepository.findByCustomerCategoryNameIgnoreCase(customerCategoryRequestBeanRequest.getCustomerCategory().trim())!=null){
			_errors.reject("CUSTOMER CATEGORY ALREADY EXISTS","PLEASE REFER API FOR VALUES");
		}

	
	}

}
