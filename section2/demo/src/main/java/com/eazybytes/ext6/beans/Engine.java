package com.eazybytes.ext6.beans;

public class Engine {

    public Engine() {
        System.out.println("Engine bean created by spring");
    }
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                '}';
    }
}
