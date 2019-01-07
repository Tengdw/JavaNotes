package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * 使括号有效的最少添加
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 10:53
 */
public class LeetCode921 {
    class Solution {
        public int minAddToMakeValid(String S) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
            return stack.size();
        }
    }

    @Test
    public void test() {
        // "()))(("
        int i = new Solution().minAddToMakeValid(")");
        System.out.println(i);
    }
}
