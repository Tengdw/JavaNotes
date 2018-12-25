package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 11:43
 */
public class LeetCode107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> list = new ArrayList<>(count);
                while (count > 0) {
                    TreeNode node = queue.remove();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    count--;
                }
                result.add(list);
            }
            Collections.reverse(result);
            return result;
        }
    }
}
