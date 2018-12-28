package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 左叶子之和
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 17:47
 */
public class LeetCode404 {
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int res = 0;
            if (root == null) return res;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null)
                    res += root.left.val;
                else
                    res += sumOfLeftLeaves(root.left);
            }
            res += sumOfLeftLeaves(root.right);
            return res;
        }


    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        int i = new Solution().sumOfLeftLeaves(root);
        System.out.println(i);
    }
}
