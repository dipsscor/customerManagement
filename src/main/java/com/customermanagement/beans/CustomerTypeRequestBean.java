package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerTypeRequestBean {
	
	@NotNull(message="CUSTOMER TYPE NAME CANNOT BE NULL")
	@NotBlank(message="CUSTOMER TYPE NAME CANNOT BE BLANK")
	@ApiModelProperty(example="STANDARD")
	private String customerType;
	
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
