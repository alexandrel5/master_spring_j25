package com.eazybytes.ext;

import com.eazybytes.ext.beans.Vehicle;
import com.eazybytes.ext.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMainClass {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean("vehicle1",Vehicle.class);
        System.out.println("Vehicle name from Spring context is: " + veh.getName());

        var vehicle = (Vehicle) context.getBean("vehicle2");
        System.out.println("Vehicle name from Spring context is: " + vehicle.getName());


    }
}
