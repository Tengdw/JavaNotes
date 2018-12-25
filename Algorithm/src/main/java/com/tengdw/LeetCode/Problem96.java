package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 不同的二叉搜索树
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 11:39
 */
public class Problem96 {
    /*
    假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
    当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
    所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    用动态规划来做
     */
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++)
                for (int j = 1; j <= i; j++)
                    dp[i] += dp[j - 1] * dp[i - j];
            return dp[n];
        }
    }

    @Test
    public void test() {
        int i = new Solution().numTrees(3);
        System.out.println(i);

    }

    @Test
    public void test1() {
        String solution = solution("10 10 11 12 12 11 16");
        System.out.println(solution);

    }
    private static String solution(String line) {
        String[] str = line.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : str) {
            if (list.contains(s))
                list.remove(s);
            else
                list.add(s);
        }
        return list.get(0);
    }
}
