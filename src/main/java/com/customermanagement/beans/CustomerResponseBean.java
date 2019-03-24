package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

public class CustomerResponseBean {
	
	@ApiModelProperty(example="C9001")
	private String customerDisplayId;
	
	@ApiModelProperty(example="CUSTOMER CREATED/UPDATED/DELETED SUCCESSFULLY")
	private String message;

	public String getCustomerDisplayId() {
		return customerDisplayId;
	}

	public void setCustomerDisplayId(String customerDisplayId) {
		this.customerDisplayId = customerDisplayId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
