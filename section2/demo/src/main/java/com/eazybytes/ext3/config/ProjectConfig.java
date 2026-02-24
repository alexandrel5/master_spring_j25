package com.eazybytes.ext3.config;

import com.eazybytes.ext3.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
Spring @Configuration annotation is part of the Spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the applications.
 */

@Configuration
@ComponentScan(basePackages = {"com.eazybytes.ext3.beans"})
public class ProjectConfig {


}
