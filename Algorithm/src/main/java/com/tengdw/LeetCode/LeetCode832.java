package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 翻转图像
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/9 16:55
 */
public class LeetCode832 {
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                int m = 0, n = A[i].length - 1;
                while (m <= n) {
                    if (m == n) {
                        A[i][m] = A[i][m]^1;
                        break;
                    }
                    int temp = A[i][m];
                    A[i][m] = A[i][n]^1;
                    A[i][n] = temp^1;
                    m++;
                    n--;
                }
            }
            return A;
        }

    }

    @Test
    public void test() {
        int[][] ints = {{1},{1},{1}};
        int[][] result = new Solution().flipAndInvertImage(ints);
        for (int i = 0; i < result.length; i++) {
            System.out.println();
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
        }
    }
}
