package com.eazybytes.ext5.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    private Coffee coffee;

    @Autowired //Optional
    public CoffeeShop(@Qualifier("cappuccino") Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }
}
