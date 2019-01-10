package com.tengdw.LeetCode;

import java.util.Arrays;

/**
 * 数组拆分 I
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/10 10:26
 */
public class LeetCode561 {
    class Solution {
        public int arrayPairSum(int[] nums) {
            int result = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i+=2) {
                result+=nums[i];
            }
            return result;
        }
    }
}
