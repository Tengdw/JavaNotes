package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 卡牌分组
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 10:37
 */
public class LeetCode914 {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : deck)
                map.put(num, map.getOrDefault(num, 0) + 1);
            //求最大公约数
            int maxGCD = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxGCD == -1) maxGCD = entry.getValue();
                maxGCD = gcd(maxGCD, entry.getValue());
            }
            return maxGCD >= 2;
        }
        private int gcd(int x, int y) {
            return x == 0 ? y : gcd(y % x, x);
        }
    }

    @Test
    public void test() {
        int[] deck = {1, 1, 2, 2, 2, 2};
        boolean ans = new Solution().hasGroupsSizeX(deck);
        System.out.println(ans);
    }
}
