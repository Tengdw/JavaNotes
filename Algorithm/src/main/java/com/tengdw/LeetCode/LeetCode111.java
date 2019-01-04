package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树的最小深度
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/4 15:49
 */
public class LeetCode111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.right == null)
                return minDepth(root.left) + 1;
            if (root.left == null)
                return minDepth(root.right) + 1;
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        int i = new Solution().minDepth(root);
        System.out.println(i);
    }
}
