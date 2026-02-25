package com.eazybytes.ext4.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("Car bean created");
    }
    private String name;

    //@Autowired
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Kia";
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
