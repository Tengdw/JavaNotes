package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉搜索树的最小绝对差
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 17:04
 */
public class LeetCode530 {
    class Solution {
        int pre = -1, minAbs = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minAbs;
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            if (pre == -1) pre = node.val;
            else minAbs = Math.min(minAbs, Math.abs(node.val - pre));
            pre = node.val;
            inOrder(node.right);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,null,3,2]");
        int ans = new Solution().getMinimumDifference(root);
        System.out.println(ans);
    }
}
