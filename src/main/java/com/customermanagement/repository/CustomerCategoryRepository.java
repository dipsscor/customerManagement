package com.customermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customermanagement.model.CustomerCategory;

public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory, Serializable>{
	
	public CustomerCategory findByCustomerCategoryNameIgnoreCase(String _customerCategoryName);


}
