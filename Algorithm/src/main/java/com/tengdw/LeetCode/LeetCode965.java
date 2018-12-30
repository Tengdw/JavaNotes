package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 单值二叉树
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-30 12:24
 **/
public class LeetCode965 {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            return dfs(root, root.val);
        }

        //深度搜索把每个节点的值和根节点比较 全部相同则为单值二叉树
        private boolean dfs(TreeNode node, int val) {
            if (node == null)
                return true;
            if (val != node.val)
                return false;
            return dfs(node.left, val) && dfs(node.right, val);
        }
    }
}
