package com.eazybytes.ext4;

import com.eazybytes.ext4.beans.Person;
import com.eazybytes.ext4.beans.Vehicle;
import com.eazybytes.ext4.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var person = context.getBean( Person.class);
        var vehicle = context.getBean( Vehicle.class);
        System.out.println("Person name from Spring Context is: "+person.getName());
        System.out.println("Vehicle name from Spring Context is: "+vehicle.getName());
        System.out.println("Vehicle that Person own is: "+person.getVehicle());
    }
}
