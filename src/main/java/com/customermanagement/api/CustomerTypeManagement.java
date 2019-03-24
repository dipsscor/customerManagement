package com.customermanagement.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.beans.CustomerTypeRequestBean;
import com.customermanagement.beans.CustomerTypeResponseBean;
import com.customermanagement.config.ApplicationConfigurationLoader;
import com.customermanagement.model.CustomerType;
import com.customermanagement.service.CustomerManagementProcessor;
import com.customermanagement.util.ResponseBeanConverter;
import com.customermanagement.validator.CustomerTypeRequestBeanValidator;

@RestController
@RequestMapping("/CUSTOMER-MANAGEMENT/V1.0")
// Swagger Specific Annotations
@Api(value = "CUSTOMER TYPE MANAGEMENT", description = "CUSTOMER TYPE MANAGEMENT")
public class CustomerTypeManagement {
	
	private static final Logger logger = Logger.getLogger(CustomerTypeManagement.class.getName());

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	@Autowired
	CustomerManagementProcessor customerManagementProcessor;
	
	@Autowired
	ResponseBeanConverter responseBeanConverter;
	
	
	//VALIDATOR CONFIGURATIONS
	@Autowired
	CustomerTypeRequestBeanValidator customerTypeRequestBeanValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customerTypeRequestBeanValidator);
	}
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "LIST ALL CUSTOMER TYPES")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CUSTOMER-TYPE/LIST", method = RequestMethod.GET, produces = { "application/json" })
	public List<CustomerType> getAllCustomerTypes() {
		
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: getAllCustomerTypes(), Message: Processing Request");
			return customerManagementProcessor.getQueryOperationsHandler().getAllCustomerTypes();
	}
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CREATE CUSTOMER TYPE")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CUSTOMER-TYPE/CREATE", method = RequestMethod.POST, produces = { "application/json","application/x-javascript","application/javascript"},consumes = { "application/json","application/x-javascript","application/javascript" })
	public CustomerTypeResponseBean createCustomerType(@Valid @RequestBody CustomerTypeRequestBean _request) {
		
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: createCustomerType(), Message: Processing Request");
		return customerManagementProcessor.getCrudOperationsHandler().createCustomerType(_request);
	}
	
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "REMOVE CUSTOMER TYPE")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CUSTOMER-TYPE/REMOVE", method = RequestMethod.DELETE, produces = { "application/json","application/x-javascript","application/javascript"})
	public CustomerTypeResponseBean removeCustomerType(	@RequestParam(name="customerTypeId",required=true) Long _customerTypeId) {
		
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: removeCustomerType(), Message: Processing Request");
		return customerManagementProcessor.getCrudOperationsHandler().removeCustomerType(_customerTypeId);
	}
	

}
