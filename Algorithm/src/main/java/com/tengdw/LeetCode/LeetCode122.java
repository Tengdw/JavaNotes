package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 买卖股票的最佳时机 II  最多交易次数
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 17:42
 */
public class LeetCode122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i - 1] < prices[i])
                    max += prices[i] - prices[i - 1];
            return max;
        }
    }

    @Test
    public void test() {
        int[] ints = {1,2,3,4,5};
        int i = new Solution().maxProfit(ints);
        System.out.println(i);
    }
}
