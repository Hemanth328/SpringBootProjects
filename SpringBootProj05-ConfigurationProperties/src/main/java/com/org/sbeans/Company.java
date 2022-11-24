package com.org.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("company")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.com")
@PropertySource("Some.properties")
public class Company {
	
	private int companyId;
	
	private String companyName;
	
	private String companyAddress;
	
	@Value("${com.mobile}")  // Though we pass the value from @Value annotation later by setter method execution @configurationPropertie file value will be overridden
	private Long companyMobile;
	
	@Value("${com.size}")  // Though we define the same value in user defined properties it will be overridden by application.properties file
	private int size;
}
