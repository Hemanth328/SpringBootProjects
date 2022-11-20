package com.org.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

    @Autowired
    @Qualifier("pEngine")
    private IEngine engine;

    public Vehicle(){
        System.out.println("Vehicle: 0-param Constructor");
    }

    public void takeRide(String source, String destination){
        engine.source(source);
        engine.destination(destination);
    }
}
