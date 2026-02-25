package com.eazybytes.ext7.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)// Optional
public class MyService {
    public MyService() {
        System.out.println("MyService bean is created");
    }
}
