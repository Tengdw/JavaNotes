package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 买卖股票的最佳时机  只允许交易一次
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 11:58
 */
public class LeetCode121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0, minProfit = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++)
                if (prices[i] < minProfit)
                    minProfit = prices[i];
                else if (prices[i] - minProfit > maxProfit)
                    maxProfit = prices[i] - minProfit;

            return maxProfit;
        }
    }

    //DP
    class Solution1 {
        public int maxProfit(int[] prices) {
            // maxProfitSoFar 为截止到当前“日期”（索引） 能够获得的最大收益
            int len = prices.length, maxProfitSoFar = 0;
            // 保存 maxProfitSoFar
            int[] sums = new int[len];
            for (int i = 1; i < len; i++) {
                sums[i] = Math.max(0, sums[i - 1] + prices[i] - maxProfitSoFar);
                maxProfitSoFar = Math.max(sums[i], maxProfitSoFar);
            }
            return maxProfitSoFar;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int buy = Integer.MAX_VALUE, sell = 0;
            for (int i = 1; i < prices.length; i++) {
                sell = Math.max(sell, prices[i] - buy);
                buy = Math.min(buy, prices[i]);
            }
            return sell;
        }
    }

    @Test
    public void test() {
        int[] prices = {7,6,4,3,1};
        int result = new Solution().maxProfit(prices);
        System.out.println(result);
    }
}
