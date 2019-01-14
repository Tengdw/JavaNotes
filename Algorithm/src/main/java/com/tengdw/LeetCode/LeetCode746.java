package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 使用最小花费爬楼梯
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 16:16
 */
public class LeetCode746 {
    //超时
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
                return dp(cost, cost.length);
        }
        public int dp(int[] cost, int n) {
            if (n == 0 || n == 1)
                return 0;
            else
                return Math.min(cost[n - 1] + dp(cost, n - 1), cost[n - 2] + dp(cost, n - 2));
        }
    }

    class Solution1 {
        public int minCostClimbingStairs(int[] cost) {
            int length = cost.length;
            int[] result = new int[length + 1];
            for (int i = 2; i < length + 1; i++) {
                result[i] = Math.min(cost[i - 1] + result[i - 1], cost[i - 2] + result[i - 2]);
            }
            return result[length];
        }
    }

    class Solution2 {
        public int minCostClimbingStairs(int[] cost) {
            int step1 = cost[0], step2 = cost[1];
            for (int i = 2; i < cost.length; i++) {
                int temp = step2;
                step2 = cost[i] + Math.min(step1, step2);
                step1 = temp;

            }
            return Math.min(step1, step2);
        }
    }



    @Test
    public void test() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = new Solution2().minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
