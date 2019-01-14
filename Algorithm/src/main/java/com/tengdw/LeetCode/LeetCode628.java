package com.tengdw.LeetCode;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 15:51
 */
public class LeetCode628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length - 1;
            return Math.max(nums[len] * nums[len - 1] * nums[len - 2], nums[len] * nums[0] * nums[1]);
        }
    }

    class Solution1 {
        public int maximumProduct(int[] nums) {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }

                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }
            return Math.max(max1 * max2 * max3, max1 * min1 * min2);
        }
    }
}
