package com.xgcd.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/")
public class HelloWorld {

    @Value("${person.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello World!" + name;
    }
}
