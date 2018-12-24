package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 二叉树的前序遍历
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/24 15:53
 */
public class Problem144 {
    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return list;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }

    class Solution2 {
        //迭代
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return list;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,null,2,3]");
        List<Integer> list = new Solution().preorderTraversal(root);
        System.out.println(list);
    }
}
