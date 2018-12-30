package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 递增顺序查找树
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 10:13
 */
public class LeetCode897 {
    class Solution {
        TreeNode pre = null;
        TreeNode dummyNode = null;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) return root;
            inOrder(root);
            return dummyNode;
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            if (pre == null) {
                pre = node;
                dummyNode = node;
            } else {
                pre.right = node;
                node.left = null;
                pre = node;
            }
            inOrder(node.right);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[]");
        new Solution().increasingBST(root);
    }
}
