package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 测试用例 [25,15,35,7,20,30,40,5,10,17,23,27,32,37,43]
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/19 11:29
 */
public class LeetCode94 {
    class Solution {
/*

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list;
        }

*/
        //非递归解法
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                //循坏开始时会将树的根节点和根节点左侧的所有左孩子节点入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }

        private void inorder(TreeNode node, List<Integer> list) {
            if (node != null) {
                inorder(node.left, list);
                list.add(node.val);
                inorder(node.right, list);
            }
        }
    }
    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,8]");
        List<Integer> list = new Solution().inorderTraversal(root);
        System.out.println(list);
    }
}
