package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 10:22
 */
public class LeetCode701 {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
