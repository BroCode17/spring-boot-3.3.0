package com.efrimpon.lesson;

import org.springframework.stereotype.Component;


public class FirstClass {

    private final String myVar;

    public FirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello World from First Class ===> myVar =" + myVar;
    }

}
