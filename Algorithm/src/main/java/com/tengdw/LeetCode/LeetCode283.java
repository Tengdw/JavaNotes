package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移动零
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-12 10:47
 **/
public class LeetCode283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int x = 0, y = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] != 0)
                    nums[x++] = nums[i];
                else
                    y++;

            for (int i = nums.length - y; i < nums.length; i++)
                nums[i] = 0;

        }
    }

    @Test
    public void test() {
        int[] nums = {0,0,0,1};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
