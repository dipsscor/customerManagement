package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

public class CustomerTypeResponseBean {

	@ApiModelProperty(example="PREMIUM | STANDARD")
	private String customerTypeName;
	
	@ApiModelProperty(example="CUSTOMER TYPE CREATED/DELETED SUCCESSFULLY")
	private String message;
	
	
	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
