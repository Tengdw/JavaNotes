package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找到所有数组中消失的数字
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-12 11:39
 **/
public class LeetCode448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            List<Integer> result = new ArrayList<>();
            for (int i : nums)
                set.add(i);
            for (int i = 1; i <= nums.length; i++)
                if (!set.contains(i)) result.add(i);

            return result;
        }
    }

    class Solution1 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    int temp = nums[i];
                    if (temp == nums[temp - 1])
                        continue;
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    i--;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) result.add(i + 1);
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = new Solution1().findDisappearedNumbers(nums);
        System.out.println(list);
    }
}
