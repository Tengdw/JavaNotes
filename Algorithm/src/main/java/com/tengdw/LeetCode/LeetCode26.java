package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/16 17:17
 */
public class LeetCode26 {
    //使用指针去数组右边寻找比nums[l]大的数，找到后交换位置
    class Solution {
        public int removeDuplicates(int[] nums) {
            int l = 0, r = 1;
            while (r < nums.length) {
                if (nums[l] < nums[r]) {
                    nums[l + 1] = nums[r];
                    l++;
                }
                r++;
            }
            return l + 1;
        }
    }

    @Test
    public void test() {
        //0,0,1,1,1,2,2,3,3,4
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = new Solution().removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
