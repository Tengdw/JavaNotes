package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉树的直径
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 16:35
 */
public class LeetCode543 {
    class Solution {
        int result;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            depth(root);
            return result;
        }

        public int depth(TreeNode node) {
            if (node == null) return 0;
            int left = depth(node.left);
            int right = depth(node.right);
            result = Math.max(result, right + left);
            return Math.max(left, right) + 1;
        }
    }
}
