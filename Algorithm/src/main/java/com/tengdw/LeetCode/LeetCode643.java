package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 子数组最大平均数 I
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/17 9:26
 */
public class LeetCode643 {
    //滑动窗口
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double maxSum = Integer.MIN_VALUE;
            for (int i = 0; i + k - 1 < nums.length; i++) {
                int sum = 0;
                for (int n = 0; n < k; n++)
                    sum += nums[i+n];
                if (sum > maxSum)
                    maxSum = sum;
            }
            return maxSum / k;
        }
    }

    @Test
    public void test() {
        // 1,12,-5,-6,50,3 4
        // 0,4,0,3,2 1
        // 5 1
        // -1 1
        int[] nums = {-1};
        int k = 1;
        double ans = new Solution().findMaxAverage(nums, k);
        System.out.println(ans);
    }
}
