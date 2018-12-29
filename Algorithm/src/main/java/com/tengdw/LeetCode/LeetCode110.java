package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 平衡二叉树
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 10:39
 */
public class LeetCode110 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return getDepth(root) != -1;
        }

        public int getDepth(TreeNode node) {
            if (node == null) return 0;
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);

            if (leftDepth == -1 || rightDepth == -1)
                return -1;
            if (Math.abs(leftDepth - rightDepth) > 1)
                return -1;
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        System.out.println(new Solution().getDepth(root));
//        boolean balanced = new Solution().isBalanced(root);
//        System.out.println(balanced);
    }
}
