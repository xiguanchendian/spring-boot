package com.xgcd.thinkinginjava.io;

import java.io.File;

public class GetOriginalFileName {
    public static void main(String[] args) {
        File path = new File("pom.xml");
        System.out.println(path.getName());// pom.xml
    }
}
