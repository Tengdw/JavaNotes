package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 转置矩阵
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/10 12:01
 */
public class LeetCode867 {
    /*
    [[1,2,3],   [[1,4,7],
     [4,5,6],    [2,5,8],
     [7,8,9]]    [3,6,9]]

    [[1,2,3],  [[1,4],
     [4,5,6]]   [2,5],
                [3,6]]

     */
    class Solution {
        public int[][] transpose(int[][] A) {
            int[][] result = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    result[j][i] = A[i][j];
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] result = new Solution().transpose(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
