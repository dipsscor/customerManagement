package com.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CUSTOMER_TYPE")
public class CustomerType {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="CUSTOMER_TYPE_ID")
    private Long id;
	
    @Column(name="CUSTOMER_TYPE_NAME")
    @NotNull
	private String customerTypeName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

}
