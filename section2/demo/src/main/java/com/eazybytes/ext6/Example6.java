package com.eazybytes.ext6;

import com.eazybytes.ext6.beans.Bike;
import com.eazybytes.ext6.beans.Engine;
import com.eazybytes.ext6.beans.Vehicle;
import com.eazybytes.ext6.config.ProjectConfig;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6 {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        if(context.containsBean("engine")){
            Engine engine = (Engine) context.getBean("engine");
            System.out.println("Engine name = " + engine.getName());
        }
        if(context.containsBean("vehicle")){
            Vehicle vehicle = (Vehicle) context.getBean("vehicle");
            System.out.println("Vehicle Name = " + vehicle.getName());
            System.out.println("Vehicle engine = " + vehicle.getEngine());
        }
        if(context.containsBean("bike")){
            Bike bike = (Bike) context.getBean("bike");
            System.out.println("Bike Model = " + bike.getName());
        }


    }
}
