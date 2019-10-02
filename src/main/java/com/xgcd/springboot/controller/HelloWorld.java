package com.xgcd.springboot.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/")
public class HelloWorld {

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }
}
