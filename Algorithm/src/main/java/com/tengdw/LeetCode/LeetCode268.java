package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 缺失数字
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-13 12:21
 **/
public class LeetCode268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int i = 1; i <= nums.length; i++) {
                sum += i;
            }
            for (int i = 0; i < nums.length; i++) {
                sum -= nums[i];
            }
            return sum;
        }
    }

    class Solution1 {
        public int missingNumber(int[] nums) {
            int sum = nums.length;
            for (int i = 0; i < nums.length; i++) {
                sum ^= nums[i];
                sum ^= i;
            }

            return sum;
        }
    }

    @Test
    public void test() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int i = new Solution().missingNumber(nums);
        System.out.println(i);
    }
}
