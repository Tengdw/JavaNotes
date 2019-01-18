package com.tengdw.LeetCode;

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
}
