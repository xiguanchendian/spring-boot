package com.xgcd.springboot.mianshi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringMatching {
    /**
     * 题目：判断给定字符串中的括号是否匹配
     */
    private static final Map<Character, Character> brackets = new HashMap<>();
    static {
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
    }
    public static boolean isMatching(String str) {
        if (str == null) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (brackets.containsValue(ch)) {
                stack.push(ch);
            } else if (brackets.containsKey(ch)) {
                if (stack.empty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        String str = "TRUMP{}IS()A{[(FOOL)]}WE{NEED}X[D]PB";
        boolean matching = isMatching(str);
        // true
        System.out.println(matching);
    }
}
