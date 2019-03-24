package com.customermanagement.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="CUSTOMER_ID")
    private Long id;
	
	@Column(name="CUSTOMER_DISPLAY_ID")
    @NotNull
	private String customerDisplayId;
 
    @Column(name="CUSTOMER_NAME")
    @NotNull
	private String customerName;
    
    @Column(name="EMAIL_ADDRESS")
    @NotNull
	private String emailAddress;
    

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CATEGORY_ID",updatable=false)
	private CustomerCategory customerCategory;
	
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_TYPE_ID",updatable=false)
	private CustomerType customerType;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="CUSTOMER_ADDRESS_MAPPING",joinColumns=@JoinColumn(name="CUSTOMER_ID"),inverseJoinColumns=@JoinColumn(name = "CUSTOMER_ADDRESS"))
	private Set<CustomerAddress> customerAddresses;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="CUSTOMER_ADDTIONAL_ATTRIBUTES_MAPPING",joinColumns=@JoinColumn(name="CUSTOMER_ID"),inverseJoinColumns=@JoinColumn(name = "ADDTIONAL_ATTRIBUTE_ID"))
	private List<AdditionalAttributes> additionalAttributes;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerDisplayId() {
		return customerDisplayId;
	}

	public void setCustomerDisplayId(String customerDisplayId) {
		this.customerDisplayId = customerDisplayId;
	}

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

	public CustomerCategory getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(CustomerCategory customerCategory) {
		this.customerCategory = customerCategory;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Set<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public List<AdditionalAttributes> getAdditionalAttributes() {
		return additionalAttributes;
	}

	public void setAdditionalAttributes(
			List<AdditionalAttributes> additionalAttributes) {
		this.additionalAttributes = additionalAttributes;
	}
}
