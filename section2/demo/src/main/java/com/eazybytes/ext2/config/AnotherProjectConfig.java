package com.eazybytes.ext2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherProjectConfig {

    @Bean
    String helloWorld() {
        return "Hello World!";
    }

    @Bean
    Integer luckNumber() {
        return 16;
    }
}
