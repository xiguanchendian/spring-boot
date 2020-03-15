package com.xgcd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigIntegerTest {

    @Test
    public void compareTest() {


        String receive = "0.2";
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        String pattern2 = "^[1-9]\\d*$";
        boolean matches = Pattern.matches(pattern2, receive);
        if (matches) {
            BigInteger bigInteger = new BigInteger(receive);
            System.out.println("合法");
            if (bigInteger.compareTo(new BigInteger("0")) <= 0 || bigInteger.compareTo(new BigInteger("1800")) > 0) {
                System.out.println("参数不在范围");

            } else {
                System.out.println("参数合法");
            }
        } else {
            System.out.println("不合法");
        }

    }
}
