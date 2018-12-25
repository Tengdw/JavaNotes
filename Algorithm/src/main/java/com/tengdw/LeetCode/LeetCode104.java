package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉树的最大深度
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/18 15:40
 */
public class LeetCode104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //算左孩子最大深度
            int leftDepth =  1 + maxDepth(root.left);
            //算右孩子最大深度
            int rightDepth = 1 + maxDepth(root.right);
            return leftDepth > rightDepth ? leftDepth : rightDepth;
//            最简单的
//            return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

}
