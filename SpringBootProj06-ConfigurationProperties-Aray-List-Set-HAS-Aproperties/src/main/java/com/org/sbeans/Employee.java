package com.org.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("employee")
@Data
@ConfigurationProperties(prefix = "org.com")
public class Employee {
	private Integer eno;
	private String ename;
	private String[] favColours;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String, Object> idDetails;
	
	//HAS-A property
	private Company company;

}
