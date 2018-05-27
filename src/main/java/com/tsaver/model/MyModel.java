package com.tsaver.model;

import org.springframework.stereotype.Component;

@Component
public class MyModel {
    private String name;

    public MyModel() {
        this.name = "Default name";
    }

    public MyModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
