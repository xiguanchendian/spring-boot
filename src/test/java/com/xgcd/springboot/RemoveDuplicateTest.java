package com.xgcd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoveDuplicateTest {
    @Test
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("aaa");
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println(">>>>>>>>>去重");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);
        ArrayList<String> removeDuplicateList = new ArrayList<>(linkedHashSet);
        for (String str : removeDuplicateList) {
            System.out.println(str);
        }
    }
}
