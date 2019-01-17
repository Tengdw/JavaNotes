package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/17 17:26
 */
public class LeetCode88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }

    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j])
                    nums1[k--] = nums1[i--];
                else
                    nums1[k--] = nums2[j--];
            }
            while (j >= 0)
                nums1[k--] = nums2[j--];
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Solution1().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
