package com.tengdw.LeetCode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 两个数组的交集
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-22 13:11
 **/
public class LeetCode349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            ArrayList<Integer> result = new ArrayList<>();
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            for (int num : nums2) {
                if (set.contains(num)) {
                    result.add(num);
                    set.remove(num);
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }
}
