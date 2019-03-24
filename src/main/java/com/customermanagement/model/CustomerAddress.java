package com.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CUSTOMER_ADDRESS")
public class CustomerAddress {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="CUSTOMER_ADDRESS_ID")
    private Integer id;
	
	@Column(name="ADDRESS_LINE1")
    @NotNull
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
    @NotNull
	private String addressLine2;
	
	@Column(name="COUNTRY")
    @NotNull
	private String country;
	
	@Column(name="STATE")
    @NotNull
	private String state;
	
	@Column(name="CITY")
    @NotNull
	private String city;
	
	@Column(name="ZIPCODE")
    @NotNull
	private String zipCode;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
