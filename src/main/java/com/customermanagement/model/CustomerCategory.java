package com.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CUSTOMER_CATEGORY")
public class CustomerCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="CUSTOMER_CATEGORY_ID")
    private Long id;
	
    @Column(name="CUSTOMER_CATEGORY_NAME")
    @NotNull
	private String customerCategoryName;
    
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerCategoryName() {
		return customerCategoryName;
	}

	public void setCustomerCategoryName(String customerCategoryName) {
		this.customerCategoryName = customerCategoryName;
	}



}
