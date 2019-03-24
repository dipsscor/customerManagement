package com.customermanagement.beans;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerAddressRequestBean {
	
	@NotNull(message="ADDRESS LINE 1 CANNOT BE NULL")
	@NotBlank(message="ADDRESS LINE 1 CANNOT BE BLANK")
	@ApiModelProperty(example="330 Potrero Ave")
	private String addressLine1;
	
	
	@ApiModelProperty(example="xyz street")
	private String addressLine2;
	
	
	@NotNull(message="COUNTRY CANNOT BE NULL")
	@NotBlank(message="COUNTRY CANNOT BE BLANK")
	@ApiModelProperty(example="USA")
	private String country;
	
	
	@NotNull(message="STATE CANNOT BE NULL")
	@NotBlank(message="STATE CANNOT BE BLANK")
	@Size(min=2,max=3,message="VALUE OF STATE SHOULD BE BETWEEN 2 - 3 CHARACTERS")
	@ApiModelProperty(example="CA")
	private String state;
	
	
	@NotNull(message="CITY CANNOT BE NULL")
	@NotBlank(message="CITY CANNOT BE BLANK")
	@ApiModelProperty(example="Sunnyvale")
	private String city;
	
	
	@NotNull(message="ZIP-CODE CANNOT BE NULL")
	@NotBlank(message="ZIP-CODE CANNOT BE BLANK")
	//@Pattern(regexp="/^(0|[1-9]\\d*)$/",message="ZIP-CODE SHOULD BE NUMBER ONLY WITHOUT DECIMAL")
	@ApiModelProperty(example="90001")
	private String zipCode;
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


}
