package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-12 17:47
 **/
public class LeetCode217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++)
                for (int j = i + 1; j < nums.length; j++)
                    if (nums[i] == nums[j]) return true;

            return false;
        }
    }

    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
            }
            return false;
        }
    }

    @Test
    public void test() {
        int[] nums = {3,3};
        boolean result = new Solution1().containsDuplicate(nums);
        System.out.println(result);
    }
}
