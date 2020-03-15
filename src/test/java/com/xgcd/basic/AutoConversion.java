package com.xgcd.basic;

import java.util.ArrayList;

public class AutoConversion {
    public static void main(String[] args) {
//        // 基本类型变量直接赋给包装类对象
//        Integer inObj = 5;
//        // 基本类型变量直接赋给Object对象
//        Object boolObj = true;
//        // 直接把一个Integer对象赋给int类型的变量
//        int it = inObj;
//        if (boolObj instanceof Boolean) {
//            // 先把Object对象强转为Boolean类型，再赋给boolean变量
//            boolean b = (Boolean) boolObj;
//            System.out.println(b);// true
//        }
//
//        Integer a = new Integer(6);
//        System.out.println(a > 5.0);// true
//
//        System.out.println(new Integer(2) == new Integer(2));// false
//
//        Integer ina = 2;
//        Integer inb = 2;
//        System.out.println(ina == inb);// true
//        Integer biga = 128;
//        Integer bigb = 128;
//        System.out.println(biga == bigb);// false

        // 为什么需要包装类
        ArrayList<Object> list = new ArrayList<>();
        int number1 = 11;
        boolean add = list.add(number1);
        System.out.println("add:" + add);
        Object remove = list.remove(Integer.valueOf(number1));
        System.out.println("remove:" + remove);

    }
}
