package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 加一
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/15 17:22
 */
public class LeetCode66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length - 1;
            int i = len;
            while (i >= 0) {
                if (digits[i] + 1 < 10) {
                    digits[i]++;
                }
                if (digits[i] + 1 < 10)
                i--;
            }
            return digits;
        }
    }

    @Test
    public void test() {
        int[] digits = {9, 9, 9};
        int[] result = new Solution().plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
