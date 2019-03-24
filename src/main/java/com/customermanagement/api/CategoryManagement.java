package com.customermanagement.api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.beans.CustomerCategoryRequestBean;
import com.customermanagement.beans.CustomerCategoryResponseBean;
import com.customermanagement.config.ApplicationConfigurationLoader;
import com.customermanagement.model.CustomerCategory;
import com.customermanagement.service.CustomerManagementProcessor;
import com.customermanagement.util.ResponseBeanConverter;
import com.customermanagement.validator.CustomerCategoryRequestBeanValidator;
import com.customermanagement.validator.CustomerRequestBeanValidator;

@RestController
@RequestMapping("/CUSTOMER-MANAGEMENT/V1.0")
// Swagger Specific Annotations
@Api(value = "CUSTOMER CATEGORY MANAGEMENT", description = "CUSTOMER CATEGORY MANAGEMENT")
public class CategoryManagement {
	
	private static final Logger logger = Logger.getLogger(CategoryManagement.class.getName());

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	@Autowired
	CustomerManagementProcessor customerManagementProcessor;
	
	@Autowired
	ResponseBeanConverter responseBeanConverter;
	
	
	//VALIDATOR CONFIGURATIONS
	@Autowired
	CustomerCategoryRequestBeanValidator customerCategoryRequestBeanValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customerCategoryRequestBeanValidator);
	}
	
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "LIST ALL CUSTOMER CATEGORIES")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CATEGORY/LIST", method = RequestMethod.GET, produces = { "application/json" })
	public List<CustomerCategory> getAllCustomerCategories() {
		
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: getAllCustomerCategories(), Message: Processing Request");
			return customerManagementProcessor.getQueryOperationsHandler().getAllCustomerCategories();
	}
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CREATE CUSTOMER CATEGORY")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CATEGORY/CREATE", method = RequestMethod.POST, produces = { "application/json","application/x-javascript","application/javascript"},consumes = { "application/json","application/x-javascript","application/javascript" })
	public CustomerCategoryResponseBean createCustomerCategory(@Valid @RequestBody CustomerCategoryRequestBean _request) {
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: createCustomerCategory(), Message: Processing Request");
		return customerManagementProcessor.getCrudOperationsHandler().createCustomerCategory(_request);
	}
	
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "REMOVE CUSTOMER CATEGORY")
	// Swagger Specific Annotation
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/CATEGORY/REMOVE", method = RequestMethod.DELETE, produces = { "application/json","application/x-javascript","application/javascript"})
	public CustomerCategoryResponseBean removeCustomerCategory(	@RequestParam(name="customerCategoryId",required=true) Long _customerCategoryId) {
		logger.log(Level.INFO, "Service Name:customer-management-service , API Name: removeCustomerCategory(), Message: Processing Request");
		return customerManagementProcessor.getCrudOperationsHandler().removeCustomerCategory(_customerCategoryId);
	}
	

}
