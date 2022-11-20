package com.org;

import com.org.controller.PayrollOperationsController;
import com.org.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootProj03LayeredApplication {

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
