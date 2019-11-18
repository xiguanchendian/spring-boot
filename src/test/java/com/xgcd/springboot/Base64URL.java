package com.xgcd.springboot;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64URL {
    public static void main(String[] args) {
        String str = "hello world";
        String encode = Base64.getUrlEncoder().encodeToString(str.getBytes());
        System.out.println(encode);

        String enco = "8S2KlcygY8eUvq_Dzro81IQd6oA5fxW9l9hsy8iOvtByMMJI1wKedO5sR_pJmJFYEZl6wfD4BQ-FzvSYftnO5xO8kJaHNtnrFE7R0mqpLIkf6aN02K4F9zWLad3emFTN8Ze_GqooVaa0oX6XHqpDFBQJF3kUB6cfS9mDJNq_boE";
        byte[] bytes= Base64.getUrlDecoder().decode(encode);
        try {
            String result=new String(bytes,"UTF-8");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
