package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 在二叉树中增加一行
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 16:06
 */
public class LeetCode623 {
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode newNode = new TreeNode(v);
                newNode.left = root;
                return newNode;
            }
            helper(root, d, v, 1);
            return root;
        }

        private void helper(TreeNode node, int d, int v,int depth) {
            if (node == null) return;
            if (depth == d - 1) {
                TreeNode leftTemp = node.left;
                TreeNode rightTemp = node.right;
                TreeNode newLeft = new TreeNode(v);
                TreeNode newRight = new TreeNode(v);
                node.left = newLeft;
                node.right = newRight;
                newLeft.left = leftTemp;
                newRight.right = rightTemp;
                return;
            }

            helper(node.left, d, v, depth + 1);
            helper(node.right, d, v, depth + 1);
        }

    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[4,2,6,3,1,5,7]");
        TreeNode treeNode = new Solution().addOneRow(root, 1, 3);
        System.out.println(treeNode);
    }
}
