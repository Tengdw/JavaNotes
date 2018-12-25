package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/24 11:52
 */
public class LeetCode872 {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> sequence1 = new ArrayList<>();
            List<Integer> sequence2 = new ArrayList<>();
            dfs(root1, sequence1);
            dfs(root2, sequence2);
            return sequence1.equals(sequence2);
        }

        public void dfs(TreeNode node, List<Integer> list) {
            if (node == null) return;
            if (node.left == null && node.right == null)
                list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root1.left = node1;
        root2.left = node2;
        Solution solution = new Solution();
        boolean b = solution.leafSimilar(root1, root2);
        System.out.println(b);
    }
}
