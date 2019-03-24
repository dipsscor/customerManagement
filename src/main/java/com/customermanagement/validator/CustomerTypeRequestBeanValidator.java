package com.customermanagement.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.customermanagement.beans.CustomerTypeRequestBean;
import com.customermanagement.repository.CustomerTypeRepository;
@Service
public class CustomerTypeRequestBeanValidator implements Validator{

	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerTypeRequestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors _errors) {
		CustomerTypeRequestBean customerTypeRequestBeanRequest = (CustomerTypeRequestBean) target;
		
		if(customerTypeRepository.findByCustomerTypeNameIgnoreCase(customerTypeRequestBeanRequest.getCustomerType())!=null){
			_errors.reject("CUSTOMER TYPE ALREADY EXISTS","PLEASE REFER API FOR VALUES");
		}

	}

}
