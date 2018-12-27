package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 求根到叶子节点数字之和  用深度搜索和257题很相似
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 10:03
 */
public class LeetCode129 {
    class Solution {
        int total = 0;

        public int sumNumbers(TreeNode root) {
            dfs(root, 0);
            return total;
        }

        private void dfs(TreeNode node, int sum) {
            if (node == null) return;
            sum = sum * 10 + node.val;
            if (node.left == null && node.right == null) {
                total += sum;
                return;
            }
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,null,5]");
        int i = new Solution().sumNumbers(root);
        System.out.println(i);
    }

}
