package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最短无序连续子数组
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 14:59
 */
public class LeetCode581 {
    // 排序后，分别找出排序后的数组与原数组首尾第一次出现的索引元素不相等的位置
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] arr = Arrays.copyOf(nums, nums.length);
            Arrays.sort(arr);
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                if (nums[l] == arr[l]) {
                    l++;
                    continue;
                }
                if (nums[r] == arr[r]) {
                    r--;
                    continue;
                }
                break;
            }
            return r - l + 1;
        }
    }

    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/
    // 使用栈
    class Solution1 {
        public int findUnsortedSubarray(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int l = nums.length, r = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                    l = Math.min(l, stack.pop());
                stack.push(i);
            }
            stack.clear();
            for (int i = nums.length - 1; i >= 0 ; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                    r = Math.max(r, stack.pop());
                stack.push(i);
            }
            return r - l > 0 ? r - l + 1 : 0;
        }
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 4, 5, 6, 8, 7};
        int ans = new Solution1().findUnsortedSubarray(nums);
        System.out.println(ans);
    }
}
