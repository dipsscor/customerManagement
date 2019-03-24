package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerCategoryRequestBean {
	
	@NotNull(message="CUSTOMER CATEGORY NAME CANNOT BE NULL")
	@NotBlank(message="CUSTOMER CATEGORY NAME CANNOT BE BLANK")
	@ApiModelProperty(example="BUSINESS")
	private String customerCategory;

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

}
