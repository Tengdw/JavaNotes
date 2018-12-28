package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树的最近公共祖先
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 11:02
 */
public class LeetCode236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root;
            if (root.val == p.val || root.val == q.val)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null)
                return root;
            else if (left != null)
                return left;
            else if (right != null)
                return right;

            return null;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(treeNode);
    }
}
