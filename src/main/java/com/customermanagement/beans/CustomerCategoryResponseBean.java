package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

public class CustomerCategoryResponseBean {
	
	@ApiModelProperty(example="BUSINESS | CONSUMER")
	private String customerCategoryName;
	
	@ApiModelProperty(example="CUSTOMER CATEGORY CREATED/DELETED SUCCESSFULLY")
	private String message;
	
	public String getCustomerCategoryName() {
		return customerCategoryName;
	}

	public void setCustomerCategoryName(String customerCategoryName) {
		this.customerCategoryName = customerCategoryName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
