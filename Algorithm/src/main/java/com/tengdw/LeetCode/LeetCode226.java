package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 翻转二叉树
 * https://leetcode.com/problems/invert-binary-tree/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/19 10:15
 */
public class LeetCode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            return root;
        }
    }

}
