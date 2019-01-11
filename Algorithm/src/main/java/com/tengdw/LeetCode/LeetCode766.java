package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 托普利茨矩阵
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/11 15:56
 */
public class LeetCode766 {
    /*
    [(0,0),(0,1),(0,2),(0,3)]

    [(1,0),(1,1),(1,2),(1,3)]

    [(2,0),(2,1),(2,2),(2,3)]

    1 2 3 4
    5 1 2 3
    9 5 1 2
     */
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 1; i < matrix.length; i++)
                for (int j = 1; j < matrix[i].length; j++)
                    if (matrix[i][j] != matrix[i - 1][j - 1])
                        return false;
            return true;
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean b = new Solution().isToeplitzMatrix(matrix);
        System.out.println(b);
    }
}
