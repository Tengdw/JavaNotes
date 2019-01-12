package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 最大连续1的个数
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-11 23:52
 **/
public class LeetCode485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count++;
                    if (count > result) result = count;
                } else {
                    count = 0;
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int i = new Solution().findMaxConsecutiveOnes(nums);
        System.out.println(i);
    }
}
