package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 按奇偶排序数组 II
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/10 10:58
 */
public class LeetCode922 {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int length = A.length;
            int a = 0, b = 1;
            while (a <= length - 2 && b <= length - 1) {
                //数组中偶数索引的是偶数
                if ((A[a] & 1) == 0) {
                    a += 2;
                    continue;
                }
                //数组中奇数索引的是奇数
                if ((A[b] & 1) == 1) {
                    b += 2;
                    continue;
                }
                int temp = A[a];
                A[a] = A[b];
                A[b] = temp;
            }
            return A;
        }
    }

    @Test
    public void test() {
        int[] A = {1,0};
        int[] result = new Solution().sortArrayByParityII(A);
        System.out.println(Arrays.toString(result));
    }
}
