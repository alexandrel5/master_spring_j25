package com.eazybytes.ext5.beans;

import org.springframework.stereotype.Component;

@Component
public class Cappuccino implements Coffee {

    @Override
    public String makeCoffee() {
        return "Cappuccino Coffee";
    }
}
