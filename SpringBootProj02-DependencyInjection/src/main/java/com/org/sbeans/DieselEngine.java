package com.org.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements IEngine {

    public DieselEngine(){
        System.out.println("DieselEngine : 0-param Constructor");
    }

    @Override
    public void source(String source) {
        System.out.println("Diesel Engine Ride has started from "+source);
    }

    public void destination(String destination){
        System.out.println("Diesel Engine Ride has ended at "+destination);
    }
}
