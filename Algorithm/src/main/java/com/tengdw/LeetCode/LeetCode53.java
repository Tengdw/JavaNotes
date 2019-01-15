package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 最大子序和
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/15 14:28
 */
public class LeetCode53 {

    //滑窗  超时
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE, subLen = 0;
            while (subLen++ < nums.length) {
                for (int i = 0; i + subLen <= nums.length; i++) {
                    int temp = 0;
                    for (int j = i; j < i + subLen; j++) {
                        temp += nums[j];
                    }
                    maxSum = temp > maxSum ? temp : maxSum;
                }
            }
            return maxSum;
        }
    }

    //动态规划
    class Solution1 {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return 0;
            int maxSum = nums[0], temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp = Math.max(nums[i], temp + nums[i]);
                maxSum = Math.max(temp, maxSum);
            }
            return maxSum;
        }
    }

    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new Solution1().maxSubArray(nums);
        System.out.println(result);
    }
}
