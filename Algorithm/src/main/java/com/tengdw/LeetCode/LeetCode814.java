package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉树剪枝
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/19 9:55
 */
public class LeetCode814 {

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            //把符合条件的叶子一个一个减去最后达到剪枝的效果
            if (root.left == null && root.right == null) {
                if (root.val == 0) {
                    return null;
                }
            }
            return root;
        }
    }

}
