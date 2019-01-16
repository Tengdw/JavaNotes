package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/16 10:21
 */
public class LeetCode747 {
    class Solution {
        public int dominantIndex(int[] nums) {
            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] > nums[maxIndex])
                    maxIndex = i;
            for (int i = 0; i < nums.length; i++)
                if (i != maxIndex && nums[maxIndex] < nums[i] * 2)
                    return -1;
            return maxIndex;
        }
    }

    class Solution1 {
        public int dominantIndex(int[] nums) {
            int max1 = -1, max2 = 0, maxIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max1) {
                    maxIndex = i;
                    max2 = max1;
                    max1 = nums[i];
                } else if (nums[i] > max2) {
                    max2 = nums[i];
                }
            }
            return max1 >= max2 * 2 ? maxIndex : -1;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,0};
        int ans = new Solution1().dominantIndex(nums);
        System.out.println(ans);
    }
}
