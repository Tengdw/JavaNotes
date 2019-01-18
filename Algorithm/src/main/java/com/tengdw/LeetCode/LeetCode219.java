package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 10:00
 */
public class LeetCode219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            for (int m = 1; m <= k; m++) {
                for (int i = 0; i + m < nums.length; i++)
                    if (nums[i] == nums[i + m]) return true;
            }
            return false;
        }
    }

    class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                } else if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        int[] nums = {99, 99};
        int k = 2;
        boolean ans = new Solution().containsNearbyDuplicate(nums, k);
        System.out.println(ans);
    }
}
