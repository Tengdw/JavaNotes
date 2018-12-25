package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 16:56
 */
public class LeetCode637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int divisor = size;
                double count = 0;
                while (size > 0) {
                    TreeNode node = queue.remove();
                    count += node.val;
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    size--;
                }
                result.add(count / divisor);
            }
            return result;
        }
    }
}
