package com.org.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements IEngine {

    public PetrolEngine(){
        System.out.println("PetrolEngine : 0-param Constructor");
    }
    @Override
    public void source(String source) {
        System.out.println("Petrol Engine Ride has started from "+source);
    }

    public void destination(String destination){
        System.out.println("Petrol Engine Ride has ended at "+destination);
    }
}
