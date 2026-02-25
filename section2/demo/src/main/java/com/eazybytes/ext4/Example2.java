package com.eazybytes.ext4;

import com.eazybytes.ext4.beans.Car;
import com.eazybytes.ext4.beans.Engine;
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

        var car = context.getBean( Car.class);
        var engine = context.getBean( Engine.class);
        System.out.println("Car name from Spring Context is: "+car.getName());
        System.out.println("Engine name from Spring Context is: "+engine.getName());
        System.out.println("Engine that Card own is: "+car.getEngine());
    }
}
