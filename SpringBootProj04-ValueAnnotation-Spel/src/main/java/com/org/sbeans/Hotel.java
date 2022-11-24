package com.org.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hotel")
@Data
public class Hotel {
	
	@Value("${hotel.id}")
	private int hotelID;
	
	@Value("${hotel.name}")
	private String hotelName;
	
	@Value("${hotel.address}")
	private String hotelAddress;
	
	@Value("${hotel.mobile}")
	private long mobileNumber;
	
	@Value("#{menup.dosaPrice+menup.parathaPrice}")  // SPEL for arithmetic Operation
	/* 
	SPEL is given to perform arithmetic operations while injecting the values to spring beans
	SPEL is always used in combination with @Value annotation to perform values injection to sprig bean properties by 
	performing arithmetic and logical operations.
	 syntax = #{}
	*/
	private int totalBill;
	
	@Value("${cust.name}")
	private String customerName;
	
	@Value("${os.name}")
	private String osName;
	
	@Value("${user.name}")
	private String winUserName;

}
