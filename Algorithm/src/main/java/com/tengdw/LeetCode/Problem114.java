package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树展开为链表
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 17:24
 */
public class Problem114 {
    class Solution {
        TreeNode prev = null;
        //后序遍历的顺序为 left->right->node
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

    }
}
