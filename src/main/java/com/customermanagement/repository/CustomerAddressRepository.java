package com.customermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customermanagement.model.CustomerAddress;


public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Serializable>{
	

}
