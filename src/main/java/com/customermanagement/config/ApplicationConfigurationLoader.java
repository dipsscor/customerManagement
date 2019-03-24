package com.customermanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:${config.props.path}/app-config.properties"),
	@PropertySource("classpath:${config.props.path}/swagger-config.properties")
})
public class ApplicationConfigurationLoader {
	
	/**
	 *********** SWAGGER PROPERTIES***********
	 */
	@Value("${api.customermanagement.title}")
	public String CUST_MGMT_API_TITLE;
	
	@Value("${api.customermanagement.description}")
	public String CUST_MGMT_API_DESCRIPTION;
	
	@Value("${api.customermanagement.contact.name}")
	public String CUST_MGMT_API_CONTACT_NAME;
	
	@Value("${api.customermanagement.contact.email}")
	public String CUST_MGMT_API_CONTACT_EMAIL;
	
	@Value("${api.customermanagement.version}")
	public String CUST_MGMT_API_VERSION;
	
	@Value("${api.customermanagement.terms_of_service_url}")
	public String CUST_MGMT_API_TERMS_SERVICE_URL;
	
	@Value("${api.customermanagement.license}")
	public String CUST_MGMT_API_LICENSE;
	
	@Value("${api.customermanagement.license_url}")
	public String CUST_MGMT_API_LICENSE_URL;	
	
	
	


	
	/**
	 ***************APPLICATION PROPERTIES****************
	 */

	

}
