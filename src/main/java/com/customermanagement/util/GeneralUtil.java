package com.customermanagement.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanagement.repository.CustomerRepository;

@Service
public class GeneralUtil {

	@Autowired
	private CustomerRepository customerRepository;

	public String createCustomerDisplayId() {
		Long customersCount = customerRepository.count();
		customersCount++;
		return "C900" + customersCount;

	}


}
