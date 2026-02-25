package com.eazybytes.ext5;

import com.eazybytes.ext5.config.ProjectConfig;
import com.eazybytes.ext5.beans.Coffee;
import com.eazybytes.ext5.beans.CoffeeShop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5 {
    static void main() {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var coffeeShop = context.getBean(CoffeeShop.class);
        Coffee coffee = coffeeShop.getCoffee();
        System.out.println(coffee.makeCoffee());


    }
}
