package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * 棒球比赛
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 11:52
 */
public class LeetCode682 {
    class Solution {
        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < ops.length; i++) {
                if (ops[i].equals("+")) {
                    Integer pop = stack.pop();
                    Integer peek = stack.peek();
                    stack.push(pop);
                    stack.push(pop + peek);
                } else if (ops[i].equals("D")) {
                    stack.push(stack.peek() * 2);
                } else if (ops[i].equals("C")) {
                    stack.pop();
                } else {
                    Integer num = Integer.valueOf(ops[i]);
                    stack.push(num);
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    }

    @Test
    public void test() {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int i = new Solution().calPoints(ops);
    }
}
