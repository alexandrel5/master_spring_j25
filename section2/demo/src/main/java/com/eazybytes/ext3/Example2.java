package com.eazybytes.ext3;

import com.eazybytes.ext3.beans.Vehicle;
import com.eazybytes.ext3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean( Vehicle.class);
        System.out.println("Vehicle name from Spring context is: " + veh.getName());
        veh.sayHello();
        context.close();

    }
}
