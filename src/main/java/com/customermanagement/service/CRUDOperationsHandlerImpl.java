package com.customermanagement.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanagement.beans.AdditionalAttributesRequestBean;
import com.customermanagement.beans.CustomerAddressRequestBean;
import com.customermanagement.beans.CustomerCategoryRequestBean;
import com.customermanagement.beans.CustomerCategoryResponseBean;
import com.customermanagement.beans.CustomerRequestBean;
import com.customermanagement.beans.CustomerResponseBean;
import com.customermanagement.beans.CustomerTypeRequestBean;
import com.customermanagement.beans.CustomerTypeResponseBean;
import com.customermanagement.model.AdditionalAttributes;
import com.customermanagement.model.Customer;
import com.customermanagement.model.CustomerAddress;
import com.customermanagement.model.CustomerCategory;
import com.customermanagement.model.CustomerType;
import com.customermanagement.repository.CustomerCategoryRepository;
import com.customermanagement.repository.CustomerRepository;
import com.customermanagement.repository.CustomerTypeRepository;
import com.customermanagement.util.GeneralUtil;

@Service
public class CRUDOperationsHandlerImpl implements CRUDOperationsHandler {
	
	private static final Logger logger = Logger.getLogger(CRUDOperationsHandlerImpl.class.getName());

	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerCategoryRepository customerCategoryRepository;

	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	
	/**
	 * *********** CUSTOMER******************
	 */
	
	@Override
	//@Transactional(isolation = Isolation.REPEATABLE_READ)
	public CustomerResponseBean createCustomer(CustomerRequestBean _request) {
		CustomerResponseBean customerResponseBean = new CustomerResponseBean();

		try {

			CustomerCategory category = customerCategoryRepository
					.findByCustomerCategoryNameIgnoreCase(_request
							.getCustomerCategory());
			CustomerType type = customerTypeRepository
					.findByCustomerTypeNameIgnoreCase(_request
							.getCustomerType());


			Customer customerCreated;

			Customer customer = new Customer();
			customer.setCustomerName(_request.getCustomerName());
			customer.setEmailAddress(_request.getEmailAddress());
			customer.setCustomerDisplayId(generalUtil.createCustomerDisplayId());
			customer.setCustomerCategory(category);
			customer.setCustomerType(type);
			
			//SET CUSTOMER ADDRESS
			Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>();
			for (CustomerAddressRequestBean addressBean : _request.getCustomerAddressRequestBeanList()){
				CustomerAddress customerAddress = new CustomerAddress();
				customerAddress.setAddressLine1(addressBean.getAddressLine1());
				customerAddress.setAddressLine2(addressBean.getAddressLine2());
				customerAddress.setCity(addressBean.getCity());
				customerAddress.setState(addressBean.getState());
				customerAddress.setCountry(addressBean.getCountry());
				customerAddress.setZipCode(addressBean.getZipCode());
				customerAddresses.add(customerAddress);
			}
			customer.setCustomerAddresses(customerAddresses);
			
			//SET ADDITIONAL ATTRIBUTES
			List<AdditionalAttributes> addtionalAttributes = new ArrayList<AdditionalAttributes>();
			for (AdditionalAttributesRequestBean additionalAttributeBean : _request.getAdditionalAttributesRequestBeanList()){
				AdditionalAttributes addtionalAttribute = new AdditionalAttributes();
				addtionalAttribute.setAdditionalAttributeName(additionalAttributeBean.getAdditionalAttributeName());
				addtionalAttribute.setAdditionalAttributeValue(additionalAttributeBean.getAdditionalAttributeValue());
				addtionalAttributes.add(addtionalAttribute);
			}
			customer.setAdditionalAttributes(addtionalAttributes);
			
			
			customerCreated = customerRepository.save(customer);

			customerResponseBean.setCustomerDisplayId(customerCreated
					.getCustomerDisplayId());
			customerResponseBean.setMessage("CUSTOMER CREATED SUCCESSFULLY");
		} catch (Exception exception) {
			customerResponseBean.setCustomerDisplayId(null);
			customerResponseBean.setMessage("CUSTOMER CREATION ERROR "
					+ exception.getMessage());
		}
		return customerResponseBean;
	}

	@Override
	public CustomerResponseBean updateCustomer(CustomerRequestBean _request,
			String _customerDisplayId) {
		CustomerResponseBean customerResponseBean = new CustomerResponseBean();

		try {

			CustomerCategory category = customerCategoryRepository
					.findByCustomerCategoryNameIgnoreCase(_request
							.getCustomerCategory());
			CustomerType type = customerTypeRepository
					.findByCustomerTypeNameIgnoreCase(_request
							.getCustomerType());


			Customer customer = customerRepository
					.findByCustomerDisplayIdIgnoreCase(_customerDisplayId);
			if (customer == null)
				throw new Exception("CUSTOMER NAME INVALID");

			Customer customerUpdated;

			customer.setCustomerName(_request.getCustomerName());
			customer.setCustomerCategory(category);
			customer.setCustomerType(type);
			customerUpdated = customerRepository.save(customer);

			customerResponseBean.setCustomerDisplayId(customerUpdated
					.getCustomerDisplayId());
			customerResponseBean.setMessage("CUSTOMER UPDATED SUCCESSFULLY");
		} catch (Exception exception) {
			customerResponseBean.setCustomerDisplayId(_customerDisplayId);
			customerResponseBean.setMessage("CUSTOMER UPDATION ERROR "
					+ exception.getMessage());
		}
		return customerResponseBean;
	}

	@Override
	public CustomerResponseBean removeCustomer(String _customerDisplayId) {
		CustomerResponseBean customerResponseBean = new CustomerResponseBean();
		try {

			Customer customer = customerRepository
					.findByCustomerDisplayIdIgnoreCase(_customerDisplayId);
			if (customer == null)
				throw new Exception("CUSTOMER NAME INVALID");

			customerRepository.delete(customer);

			customerResponseBean.setCustomerDisplayId(_customerDisplayId);
			customerResponseBean.setMessage("CUSTOMER DELETED SUCCESSFULLY");
		} catch (Exception exception) {
			customerResponseBean.setCustomerDisplayId(_customerDisplayId);
			customerResponseBean.setMessage("CUSTOMER DELETION ERROR "
					+ exception.getMessage());
		}
		return customerResponseBean;
	}
	
	
	/**
	 * *********** CUSTOMER CATEGORY******************
	 */

	@Override
	public CustomerCategoryResponseBean createCustomerCategory(
			CustomerCategoryRequestBean _request) {
		CustomerCategoryResponseBean customerCategoryResponseBean = new CustomerCategoryResponseBean();

		try {

			CustomerCategory customerCategoryCreated;

			CustomerCategory customerCategory = new CustomerCategory();
			customerCategory.setCustomerCategoryName(_request
					.getCustomerCategory());
			customerCategoryCreated = customerCategoryRepository
					.save(customerCategory);

			customerCategoryResponseBean
					.setCustomerCategoryName(customerCategoryCreated
							.getCustomerCategoryName());
			customerCategoryResponseBean
					.setMessage("CUSTOMER CATEGORY CREATED SUCCESSFULLY");
		} catch (Exception exception) {
			customerCategoryResponseBean.setCustomerCategoryName(null);
			customerCategoryResponseBean
					.setMessage("CUSTOMER CATEGORY CREATION ERROR "
							+ exception.getMessage());
		}
		return customerCategoryResponseBean;
	}



	@Override
	public CustomerCategoryResponseBean removeCustomerCategory(
			Long _customerCategoryId) {
		CustomerCategoryResponseBean customerCategoryResponseBean = new CustomerCategoryResponseBean();

		try {

			CustomerCategory customerCategory = customerCategoryRepository
					.findById(_customerCategoryId).orElse(null);
			if (customerCategory == null)
				throw new Exception("CUSTOMER CATEGORY ID INVALID");

			customerCategoryRepository.delete(customerCategory);

			customerCategoryResponseBean
					.setCustomerCategoryName(customerCategory
							.getCustomerCategoryName());
			customerCategoryResponseBean
					.setMessage("CUSTOMER CATEGORY DELETED SUCCESSFULLY");
		} catch (Exception exception) {
			customerCategoryResponseBean.setCustomerCategoryName(null);
			customerCategoryResponseBean
					.setMessage("CUSTOMER CATEGORY DELETION ERROR "
							+ exception.getMessage());
		}
		return customerCategoryResponseBean;
	}
	
	
	/**
	 * *********** CUSTOMER TYPE******************
	 */

	@Override
	public CustomerTypeResponseBean createCustomerType(
			CustomerTypeRequestBean _request) {
		CustomerTypeResponseBean customerTypeResponseBean = new CustomerTypeResponseBean();

		try {

			CustomerType customerTypeCreated;

			CustomerType customerType = new CustomerType();
			customerType.setCustomerTypeName(_request.getCustomerType());
			customerTypeCreated = customerTypeRepository.save(customerType);

			customerTypeResponseBean.setCustomerTypeName(customerTypeCreated
					.getCustomerTypeName());
			customerTypeResponseBean
					.setMessage("CUSTOMER TYPE CREATED SUCCESSFULLY");
		} catch (Exception exception) {
			customerTypeResponseBean.setCustomerTypeName(null);
			customerTypeResponseBean.setMessage("CUSTOMER TYPE CREATION ERROR "
					+ exception.getMessage());
		}
		return customerTypeResponseBean;
	}



	@Override
	public CustomerTypeResponseBean removeCustomerType(Long _customerTypeId) {
		CustomerTypeResponseBean customerTypeResponseBean = new CustomerTypeResponseBean();

		try {
			CustomerType customerType = customerTypeRepository
					.findById(_customerTypeId).orElse(null);
			if (customerType == null)
				throw new Exception("CUSTOMER TYPE ID INVALID");

			customerTypeRepository.delete(customerType);

			customerTypeResponseBean.setCustomerTypeName(customerType
					.getCustomerTypeName());
			customerTypeResponseBean
					.setMessage("CUSTOMER TYPE DELETED SUCCESSFULLY");
		} catch (Exception exception) {
			customerTypeResponseBean.setCustomerTypeName(null);
			customerTypeResponseBean.setMessage("CUSTOMER TYPE DELETION ERROR "
					+ exception.getMessage());
		}
		return customerTypeResponseBean;
	}

}
