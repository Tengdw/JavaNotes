package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 二叉树的层次遍历
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 11:31
 */
public class LeetCode102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode temp = queue.poll();
                    levelList.add(temp.val);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
                result.add(levelList);
            }
            return result;
        }

        //深度搜索解法
        public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
            if (root == null) return;
            if (height >= res.size()) {
                res.add(new LinkedList<Integer>());
            }
            res.get(height).add(root.val);
            levelHelper(res, root.left, height+1);
            levelHelper(res, root.right, height+1);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println(lists);
    }
}
