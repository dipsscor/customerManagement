package com.customermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customermanagement.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Serializable>{
	
	public CustomerType findByCustomerTypeNameIgnoreCase(String _customerTypeName);

}
