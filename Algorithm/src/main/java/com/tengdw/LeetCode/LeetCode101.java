package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 11:18
 */
public class LeetCode101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return helper(root.left, root.right);
        }
        private boolean helper(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return (l.val == r.val) && helper(l.left, r.right) && helper(l.right, r.left);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,2,null,3,null,3]");
        boolean symmetric = new Solution().isSymmetric(root);
        System.out.println(symmetric);
    }
}
