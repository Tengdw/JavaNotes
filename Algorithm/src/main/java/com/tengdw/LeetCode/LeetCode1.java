package com.tengdw.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/16 17:05
 */
public class LeetCode1 {

    //暴力解法
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++)
                for (int j = i + 1; j < nums.length; j++)
                    if (nums[i] + nums[j] == target)
                        return new int[]{i, j};
            return null;
        }
    }

    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = target - nums[i];
                if (map.containsKey(num))
                    return new int[]{map.get(num) ,i};
                map.put(nums[i], i);
            }

            return null;
        }
    }


}
