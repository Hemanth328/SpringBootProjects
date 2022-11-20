package com.org.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public class ElectricalEngine implements IEngine{

    public ElectricalEngine(){
        System.out.println("ElectricalEngine : 0-param Constructor");
    }
    @Override
    public void source(String source) {
        System.out.println("Electrical Engine Ride has started from "+source);
    }

    public void destination(String destination){
        System.out.println("Electrical Engine Ride has ended at "+destination);
    }
}