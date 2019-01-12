package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-12 20:48
 **/
public class LeetCode167 {
    /*
    1 2 3 4 5     7
     */
    //双指针
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l = 0, r = numbers.length - 1;
            while (l <= r) {
                if (numbers[l] + numbers[r] == target)
                    return new int[]{l + 1, r + 1};
                if (numbers[l] + numbers[r] < target) l++;
                else r--;
            }
            return null;
        }
    }

    @Test
    public void test() {
        int[] numbers = {1,2,3,4,5};
        int[] ints = new Solution().twoSum(numbers, 7);
        System.out.println(Arrays.toString(ints));
    }
}
