package com.eazybytes.ext4.config;

import com.eazybytes.ext4.beans.Person;
import com.eazybytes.ext4.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }

//    @Bean
//    Person person() {
//        Person person = new Person();
//        person.setName("Lucy");
//        person.setVehicle(vehicle());
//        return person;
//    }

    @Bean
    Person person(Vehicle vehicle) {
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle);
        return person;
    }

}
