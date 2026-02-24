package com.eazybytes.ext2;

import com.eazybytes.ext2.beans.Vehicle;
import com.eazybytes.ext2.config.AnotherProjectConfig;
import com.eazybytes.ext2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherProjectConfig.class);
        var veh = context.getBean("audiVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring context is: " + veh.getName());

        var vehicle = (Vehicle) context.getBean("myFavouriteVehicle");
        System.out.println("Vehicle name from Spring context is: " + vehicle.getName());

        var vhcle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring context is: " + vhcle.getName());

        var helloWorld = context.getBean(String.class);
        System.out.println("Vehicle value from Spring context is: " + helloWorld);
    }
}
