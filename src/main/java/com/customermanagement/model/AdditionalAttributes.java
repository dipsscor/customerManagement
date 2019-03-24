package com.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ADDTIONAL_ATTRIBUTES")
public class AdditionalAttributes {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="ADDTIONAL_ATTRIBUTE_ID")
    private Long id;
	
	@Column(name="ADDTIONAL_ATTRIBUTE_NAME")
    @NotNull
	private String additionalAttributeName;
	
	@Column(name="ADDTIONAL_ATTRIBUTE_VALUE")
    @NotNull
	private String additionalAttributeValue;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdditionalAttributeName() {
		return additionalAttributeName;
	}

	public void setAdditionalAttributeName(String additionalAttributeName) {
		this.additionalAttributeName = additionalAttributeName;
	}

	public String getAdditionalAttributeValue() {
		return additionalAttributeValue;
	}

	public void setAdditionalAttributeValue(String additionalAttributeValue) {
		this.additionalAttributeValue = additionalAttributeValue;
	}


}
