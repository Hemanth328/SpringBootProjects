package com.org.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.PersonInfo;
import com.org.service.IPersonInfoMgmtService;

@Component
public class DateTimeValuesTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonInfoMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		PersonInfo info = new PersonInfo();
		
		info.setPname("Hemanth");
		info.setPage(28.0f);
		info.setDob(LocalDate.of(1995, 12, 11));
		info.setTob(LocalTime.of(06, 00, 11));
		info.setDoj(LocalDateTime.of(2021, 07, 21, 10, 30));
		
		System.out.println(service.registerPersonInfo(info));
		
		System.out.println("\n=============================================\n");
		
		service.fetchAllPersonDetails().forEach(System.out::println);

	}

}
