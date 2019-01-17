package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 矩阵中的幻方
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/17 11:19
 */
public class LeetCode840 {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int ans = 0;
            for (int i = 0; i + 2 < grid.length; i++) {
                for (int j = 0; j + 2 < grid[i].length; j++) {
                    // 得到所有幻方的左上点的位置
                    if (isMagicSquare(grid, i, j)) ans++;
                }
            }
            return ans;
        }

        private boolean isMagicSquare(int[][] grid, int i, int j) {
            int[] nums = new int[16];
            for (int m = 0; m < 3; m++) {
                for (int n = 0; n < 3; n++) {
                    if (nums[grid[i + m][j + n]] != 0 ||
                            grid[i + m][j + n] > 9 ||
                            grid[i + m][j + n] < 1)
                        return false;
                    else nums[grid[i + m][j + n]]++;
                }
            }
            return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15 && //第一行
                    grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15 && //第二行
                    grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15 && //第三行
                    grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15 && //第一列
                    grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15 && //第一列
                    grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15 && //第一列
                    grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15 &&
                    grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15;
        }
    }

    @Test
    public void test() {
        /*
        {{4,3,8,4},
        {9,5,1,9},
        {2,7,6,2}}

        {{10,3,5},
        {1,6,11},
        {7,9,2}}

        {{10,3,5},
        {1,6,11},
        {7,9,2}}

         */
        int[][] grid =
                {{3, 2, 9, 2, 7},
                        {6, 1, 8, 4, 2},
                        {7, 5, 3, 2, 7},
                        {2, 9, 4, 9, 6},
                        {4, 3, 8, 2, 5}};
        int ans = new Solution().numMagicSquaresInside(grid);
        System.out.println(ans);
    }
}
