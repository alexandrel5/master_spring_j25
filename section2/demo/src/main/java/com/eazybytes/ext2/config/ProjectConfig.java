package com.eazybytes.ext2.config;

import com.eazybytes.ext2.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
Spring @Configuration annotation is part of the Spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the applications.
 */

@Configuration
@Import({AnotherProjectConfig.class})
public class ProjectConfig {

    /*
    @Bean annotation, which lets Spring know that it needs to call this method when it
    initializes its context and adds the returned value to the context
     */
    @Bean(name = "audiVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Primary
    @Bean(value = "hondaVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Bean({"ferrariVehicle", "myFavouriteVehicle"})
    @Description("this is a Vehicle class bean")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }

}
