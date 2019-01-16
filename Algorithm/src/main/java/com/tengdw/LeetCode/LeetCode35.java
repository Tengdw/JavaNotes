package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 搜索插入位置
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/16 9:44
 */
public class LeetCode35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (nums[i] >= target) {
                    return i;
                } else if (target > nums[length - 1]) {
                    return length;
                }
            }
            return target;
        }
    }

    //二分搜索
    class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (target > nums[mid]) {
                    l = mid + 1;
                } else if (target < nums[mid]) {
                    r = mid;
                } else {
                    return mid;
                }
            }
            return r;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = new Solution1().searchInsert(nums, target);
        System.out.println(result);
    }
}
