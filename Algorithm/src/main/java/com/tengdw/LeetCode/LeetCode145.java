package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * <p>
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/comments/3337
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/19 16:49
 */
public class LeetCode145 {
    class Solution {
/*
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postorder(root, list);
            return list;
        }
*/
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) {
                return list;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                list.addFirst(cur.val);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            return list;
        }

        private void postorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.val);
        }
    }
}
