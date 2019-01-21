package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 旋转数组
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 18:00
 */
public class LeetCode189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            k %= length;
            rollOver(nums, 0, length - 1);
            rollOver(nums, 0, k - 1);
            rollOver(nums, k, length - 1);
        }

        private void rollOver(int[] nums, int l, int r) {
            while (l < r) {
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }
    }

    class Solution1 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            k %= length;
            for (int i = 0; i < k; i++)
                rollOver(nums);

        }

        private void rollOver(int[] nums) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new Solution1().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
