package com.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.org.controller.PayrollOperationsController;
import com.org.model.Employee;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
public class SpringBootProj03LayeredApplication {
	
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
		ApplicationContext ctx = SpringApplication.run(SpringBootProj03LayeredApplication.class, args);
		
		PayrollOperationsController payroll = ctx.getBean("payroll", PayrollOperationsController.class);

        try {
            List<Employee> list = payroll.showAllEmployeeByDesg("CLERK","MANAGER", "SALESMAN");

            list.forEach(employee -> {
                System.out.println(employee);
            });

        } catch (Exception e){
            e.printStackTrace();
        }
	}

}
