package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树展开为链表
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 17:24
 */
public class LeetCode114 {
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
    /*
         1            1            1        1
       /   \        /   \        /   \       \
      2     6  ==> 2     6  ==> 2     6  ==>  2
     / \   / \      \   / \      \     \       \
    3   4 7   8      3 7   8      3     7       3
                      \            \     \       \
                       4            4     8       4
                                                   \
                                                    6
                                                     \
                                                      7
                                                       \
                                                        8
     */

    class Solution2 {
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            flatten(root.right);
            TreeNode rightNode = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = rightNode;
        }


    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        Solution2 solution = new Solution2();
        solution.flatten(root);
    }
}
