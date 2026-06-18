package com.in28minutes.rest.web.rest_web_services.versioning;

public class Personv1 {
    private String name;

    public Personv1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
