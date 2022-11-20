package com.org;

import com.org.sbeans.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProj02DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootProj02DependencyInjectionApplication.class, args);
        Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);
        vehicle.takeRide("Visakhapatnam", "Bangalore");
    }

}
