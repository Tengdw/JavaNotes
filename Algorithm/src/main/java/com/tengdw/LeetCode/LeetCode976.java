package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最大周长三角形
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 10:19
 */
public class LeetCode976 {
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 1; i >= 0; i--) {
                if (i - 2 >= 0 && A[i] < A[i - 1] + A[i - 2])
                    return A[i] + A[i - 1] + A[i - 2];
            }
            return 0;
        }
    }

    @Test
    public void test() {
        int[] A = {3,6,2,3};
        int result = new Solution().largestPerimeter(A);
        System.out.println(result);
    }
}
