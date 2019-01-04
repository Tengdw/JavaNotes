package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 另一个树的子树
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/4 11:04
 */
public class LeetCode572 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) return false;
            return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSame(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return (l.val == r.val) && isSame(l.left, r.left) && isSame(l.right, r.right);
        }
    }

    @Test
    public void test() {
        TreeNode s = TreeNode.stringToTreeNode("[1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]");
        TreeNode t = TreeNode.stringToTreeNode("[1,null,1,null,1,null,1,null,1,null,1,2]");
        boolean subtree = new Solution().isSubtree(s, t);
        System.out.println(subtree);
    }
}
