package com.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class SpringBootProj12LayeredApplicationRunnersApplication {
	
	@Autowired
	private Environment env;
	
	@Bean(name="c3p0DS")
	public ComboPooledDataSource createC3P0ds() throws Exception {
		System.out.println("SpringBootProj03LayeredApplication.createC3P0ds()");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minsize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxsize")));
		
		return cpds;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProj12LayeredApplicationRunnersApplication.class, args);
	}

}
