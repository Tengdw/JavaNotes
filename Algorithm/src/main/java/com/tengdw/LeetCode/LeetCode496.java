package com.tengdw.LeetCode;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 15:20
 */
public class LeetCode496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            //  nums2  下一个更大元素
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && stack.peek() < nums2[i])
                    map.put(stack.pop(), nums2[i]);
                stack.push(nums2[i]);
            }
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = map.getOrDefault(nums1[i], -1);
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ints = new Solution().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
