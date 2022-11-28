package com.org.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SMSAlertServiceRunner implements ApplicationRunner {
	
	

	public SMSAlertServiceRunner() {
		System.out.println("SMSAlertServiceRunner.SMSAlertServiceRunner()");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("\nSMSAlertServiceRunner.run(\n)");
		System.out.println("non-option args "+args.getNonOptionArgs());
		System.out.println("option-args keys "+args.getOptionNames());
		System.out.println("option-args values "+Arrays.toString(args.getSourceArgs()));
		
	}

}
