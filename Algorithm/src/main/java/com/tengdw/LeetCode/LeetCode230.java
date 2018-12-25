package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 17:35
 */
public class LeetCode230 {
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return 0;
            int a,b;
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list.get(k - 1);
        }

        public void inorder(TreeNode node, List<Integer> list) {
            if (node == null) return;
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }
}
