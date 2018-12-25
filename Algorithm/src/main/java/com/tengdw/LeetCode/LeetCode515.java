package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 10:35
 */
public class LeetCode515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                //当前这一层的最大值
                int max = Integer.MIN_VALUE;
                while (count > 0) {
                    TreeNode temp = queue.poll();
                    max = temp.val > max ? temp.val : max;
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    count--;
                }
                result.add(max);
            }
            return result;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[]");
        List<Integer> list = new Solution().largestValues(root);
        System.out.println(list);
    }
}
