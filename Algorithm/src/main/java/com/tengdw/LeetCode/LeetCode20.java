package com.tengdw.LeetCode;

import java.util.Stack;

/**
 * 括号匹配 https://leetcode.com/problems/valid-parentheses/description/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-09 11:51
 **/
public class LeetCode20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar != '{' && c == '}') {
                    return false;
                }
                if (topChar != '[' && c == ']') {
                    return false;
                }
                if (topChar != '(' && c == ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]})"));
        System.out.println(isValid("{[}]"));
    }

}
