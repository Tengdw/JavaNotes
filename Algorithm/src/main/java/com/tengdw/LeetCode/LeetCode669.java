package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 修剪二叉搜索树
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 14:27
 */
public class LeetCode669 {
    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) return null;
            // 该节点的值比L小，返回该节点的右子树，左子树被修剪
            if (root.val < L)
                return trimBST(root.right, L, R);
            // 该节点的值比R大，返回该节点的左子树，右子树被修剪
            if (root.val > R)
                return trimBST(root.left, L, R);
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
