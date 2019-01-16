package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 寻找数组的中心索引
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/16 12:03
 */
public class LeetCode724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = 0, leftSum = 0;
            for (int num : nums)
                sum += num;
            for (int i = 0; i < nums.length; i++) {
                if (sum - leftSum - nums[i] == leftSum)
                    return i;
                leftSum += nums[i];
            }
            return -1;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int ans = new Solution().pivotIndex(nums);
        System.out.println(ans);
    }
}
