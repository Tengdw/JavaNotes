package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 重塑矩阵
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/11 16:46
 */
public class LeetCode566 {
    /*
    可以把nums遍历出来放进一个一维数组中，然后用Arrays.copyOfRange()切片 长度为c

     */
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (r * c != nums.length * nums[0].length)
                return nums;
            int[][] result = new int[r][c];
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    result[k / c][k % c] = nums[i][j];
                    k++;
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] result = new Solution().matrixReshape(nums, 1, 4);
        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[i].length; j++)
                System.out.print(result[i][j] + ",");
    }
}
