package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 路径总和
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 12:00
 */
public class LeetCode112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            sum -= root.val;
            if (sum == 0 && root.left == null && root.right == null) return true;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2]");
        boolean b = new Solution().hasPathSum(root, 1);
        System.out.println(b);
    }
}
