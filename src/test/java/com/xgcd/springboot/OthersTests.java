package com.xgcd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OthersTests {

    public static void main(String[] args) {

        String fileName = "jdk1.8.chm";
        String newFileName = fileName.replaceFirst(fileName, ".chm");
        System.out.println(newFileName);

    }

    @Test
    public void springReplaceFirstTest() {
        String fileName = "jdk1.8.chm";
        String newFileName = fileName.replaceFirst(".chm", "");
        System.out.println(newFileName);

    }
}
