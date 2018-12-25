package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉搜索树中的搜索
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 14:45
 */
public class LeetCode700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (val == root.val) {
                return root;
            } else if (val > root.val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }
}
