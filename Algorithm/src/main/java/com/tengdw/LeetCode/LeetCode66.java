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
            int len = digits.length;
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] ans = new int[len + 1];
            ans[0] = 1;
            return ans;
        }
    }

    @Test
    public void test() {
        int[] digits = {9};
        int[] result = new Solution().plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
