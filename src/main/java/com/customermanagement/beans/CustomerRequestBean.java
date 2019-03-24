package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerRequestBean {
	

	@NotNull(message="CUSTOMER NAME CANNOT BE NULL")
	@NotBlank(message="CUSTOMER NAME CANNOT BE BLANK")
	@ApiModelProperty(example="CUSTOMER NAME")
	private String customerName;
	
	
	@NotNull(message="EMAIL ADDRESS CANNOT BE NULL")
	@NotBlank(message="EMAIL ADDRESS CANNOT BE BLANK")
	@ApiModelProperty(example="xyz@mno.com")
	private String emailAddress;
	

	@NotNull(message="CUSTOMER CATEGORY CANNOT BE NULL")
	@NotBlank(message="CUSTOMER CATEGORY CANNOT BE BLANK")
	@ApiModelProperty(example="BUSINESS | CONSUMER")
	private String customerCategory;
	
	
	@NotNull(message="CUSTOMER TYPE CANNOT BE NULL")
	@NotBlank(message="CUSTOMER TYPE CANNOT BE BLANK")
	@ApiModelProperty(example="STANDARD | PREMIUM")
	private String customerType;
	
	@NotNull(message="CUSTOMER ADDRESSES CANNOT BE NULL")
	@Valid
	private Set<CustomerAddressRequestBean> customerAddressRequestBeanList;
	
	private List<AdditionalAttributesRequestBean> additionalAttributesRequestBeanList;
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Set<CustomerAddressRequestBean> getCustomerAddressRequestBeanList() {
		return customerAddressRequestBeanList;
	}

	public void setCustomerAddressRequestBeanList(
			Set<CustomerAddressRequestBean> customerAddressRequestBeanList) {
		this.customerAddressRequestBeanList = customerAddressRequestBeanList;
	}

	public List<AdditionalAttributesRequestBean> getAdditionalAttributesRequestBeanList() {
		return additionalAttributesRequestBeanList;
	}

	public void setAdditionalAttributesRequestBeanList(
			List<AdditionalAttributesRequestBean> additionalAttributesRequestBeanList) {
		this.additionalAttributesRequestBeanList = additionalAttributesRequestBeanList;
	}


}
