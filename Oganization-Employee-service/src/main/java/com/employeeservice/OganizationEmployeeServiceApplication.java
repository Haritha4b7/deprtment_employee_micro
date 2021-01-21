package com.employeeservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Haritha Nadimpalli
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class OganizationEmployeeServiceApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(OganizationEmployeeServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(".... OganizationEmployeeServiceApplication Started  ....");
		SpringApplication.run(OganizationEmployeeServiceApplication.class, args);
	}
	
	@Bean
	public Docket organizationEmployee() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.employeeservice")).build();
	}
}
