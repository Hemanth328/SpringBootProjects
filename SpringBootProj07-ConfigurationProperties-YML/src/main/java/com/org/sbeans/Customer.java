package com.org.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("cust")
@Data
@ConfigurationProperties(prefix = "cust.info")
public class Customer {
	private Integer custNo;
	private String custName;
	private String custaddrs;
	private Double billAmt;
}