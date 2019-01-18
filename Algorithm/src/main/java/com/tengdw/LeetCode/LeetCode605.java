package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 种花问题
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 11:30
 */
public class LeetCode605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int plantCount = 0, len = flowerbed.length;
            if (len == 1 && flowerbed[0] == 0) return true;
            for (int i = 0; i < len; i++) {
                if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    plantCount++;
                }
                if (i == len - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    plantCount++;
                }
                if (i > 0 && i + 2 < len && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    plantCount++;
                }
            }
            return plantCount >= n;
        }
    }

    @Test
    public void test() {
        int[] flowerbed = {1,0,0,0,0,1};
        int n = 2;
        boolean ans = new Solution().canPlaceFlowers(flowerbed, n);
        System.out.println(ans);
    }

}
