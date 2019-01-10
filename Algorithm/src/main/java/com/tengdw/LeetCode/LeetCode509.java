package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 斐波那契数
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/10 11:31
 */
public class LeetCode509 {
    class Solution {
        public int fib(int N) {
            if (N < 2) return N;
            return fib(N - 1) + fib(N - 2);
        }
    }

    class Solution1 {
        public int fib(int N) {
            int[] nums = new int[N + 1];
            nums[0] = 0;
            nums[1] = 1;
            for (int i = 2; i <= N; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[N];
        }
    }

    class Solution2 {
        public int fib(int N) {
            if (N < 2) return N;
            int a = 0, b = 1;
            for (int i = 2; i <= N; i++) {
                int temp = b;
                b = a + b;
                a = temp;
            }
            return b;
        }
    }

    @Test
    public void test() {
        int result = new Solution2().fib(4);
        System.out.println(result);
    }
}
