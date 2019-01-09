package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/9 11:58
 */
public class LeetCode78 {
    //回溯法
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(result, new ArrayList<>(), nums, 0);
            return result;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
            list.add(new ArrayList<>(temp));
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(list, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
