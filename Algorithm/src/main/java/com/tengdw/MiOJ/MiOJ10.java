package com.tengdw.MiOJ;

/**
 * 爬楼梯
 * 动态规划经典题 dp[n] = dp[n-1] + dp[n-2]
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 17:00
 */
public class MiOJ10 {
    private static String solution(String line) {
        int n = Integer.valueOf(line);
        if(1 == n)
            return "1";
        else if(2 == n)
            return "2";
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n] + "";
    }

    public static void main(String[] args) {
        System.out.println(solution("5"));
    }
}
