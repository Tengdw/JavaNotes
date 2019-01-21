package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 非递减数列
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/21 15:27
 */
public class LeetCode665 {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int change = 0;
            int[] copy = nums.clone();
            int i = nums.length - 1;
            // 第一次，从右往左反向判断，碰到一个升高点，把前值置当前值，再次碰到就false
            for (; i > 0; i--) {
                if (nums[i - 1] > nums[i]) {
                    nums[i - 1] = nums[i];
                    change++;
                }
                if (change > 1)
                    break;
            }
            if (i == 0)
                return true;
            change = 0;
            // 第二次，从左到右判断
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j] > copy[j + 1]) {
                    copy[j + 1] = copy[i];
                    change++;
                }
                if (change > 1)
                    return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        /*
        -1,4,2,3
        3,4,2,3
        2,3,3,2,4
         */
        int[] nums = {2,3,3,2,4};
        boolean ans = new Solution().checkPossibility(nums);
        System.out.println(ans);
    }
}
