package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 最长连续递增序列
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/15 10:48
 */
public class LeetCode674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int ans = 0, cur = 0;
            if (nums.length == 0) return ans;
            for (int i = 0; i < nums.length; i++) {
                cur = 1;
                while (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                    cur++;
                    i++;
                }
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }

    class Solution1 {
        public int findLengthOfLCIS(int[] nums) {
            int ans = 0, anchor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
                ans = Math.max(ans, i - anchor + 1);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,6,6};
        int result = new Solution().findLengthOfLCIS(nums);
        System.out.println(result);
    }
}
