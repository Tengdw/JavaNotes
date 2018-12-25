package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 合并二叉树
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/18 15:09
 */
public class LeetCode617 {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            TreeNode newNode = new TreeNode(t1.val + t2.val);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
            return newNode;
        }
    }

}
