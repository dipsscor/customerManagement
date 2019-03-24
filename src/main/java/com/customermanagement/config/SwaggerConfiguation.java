package com.customermanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguation {

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	// SWAGGER 2.0 INITIATION

			// DOCKET FOR CUSTOMER MANAGEMENT API
			@Bean
			public Docket customerManagementApi() {
				return new Docket(DocumentationType.SWAGGER_2)
						.groupName("CUSTOMER-MANAGEMENT").select()
						.apis(RequestHandlerSelectors.any())
						.paths(PathSelectors.ant("/CUSTOMER-MANAGEMENT/V1.0/**")).build()
						.apiInfo(customerManagementMetaData());
			}
		

			

			//CUSTOMER MANAGEMENT METADATA
			private ApiInfo customerManagementMetaData() {
				ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
				apiInfoBuilder
						.title(CONFIG.CUST_MGMT_API_TITLE)
						.description(CONFIG.CUST_MGMT_API_DESCRIPTION)
						.contact(
								new Contact(CONFIG.CUST_MGMT_API_CONTACT_NAME, "",
										CONFIG.CUST_MGMT_API_CONTACT_EMAIL))
						.version(CONFIG.CUST_MGMT_API_VERSION)
						.termsOfServiceUrl(CONFIG.CUST_MGMT_API_TERMS_SERVICE_URL)
						.license(CONFIG.CUST_MGMT_API_LICENSE)
						.licenseUrl(CONFIG.CUST_MGMT_API_LICENSE_URL);
		
				return apiInfoBuilder.build();
			}
			
			
}
