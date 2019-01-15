package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移除元素
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/15 11:32
 */
public class LeetCode27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int l = 0, r = nums.length - 1;
            while (r >= l) {
                if (nums[r] == val) {
                    r--;
                    continue;
                }
                if (nums[l] == val) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                }
                l++;
            }
            return r + 1;
        }
    }

    class Solution1 {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }

    class Solution2 {
        public int removeElement(int[] nums, int val) {
            int i = 0, n = nums.length;
            while (i < n) {
                if (nums[i] == val) {
                    nums[i] = nums[n - 1];
                    n--;
                } else {
                    i++;
                }
            }
            return n;
        }
    }

    @Test
    public void test() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int i = new Solution1().removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }
}
