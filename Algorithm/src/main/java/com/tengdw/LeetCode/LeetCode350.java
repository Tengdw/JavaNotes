package com.tengdw.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 两个数组的交集 II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-22 14:02
 **/
public class LeetCode350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            // (元素, 频次)
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums1) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            List<Integer> list = new ArrayList<>();
            for (int num : nums2) {
                if (map.containsKey(num)) {
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                    if (map.get(num).equals(0)) {
                        map.remove(num);
                    }
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
