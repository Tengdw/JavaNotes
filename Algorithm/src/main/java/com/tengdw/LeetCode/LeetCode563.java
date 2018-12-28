package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树的坡度
 * https://leetcode.com/problems/binary-tree-tilt/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 12:02
 */
public class LeetCode563 {
    // 把所有子树的坡度值加起来就是最终结果
    class Solution {
        int tilt = 0;
        public int findTilt(TreeNode root) {
            sumTilt(root);
            return tilt;
        }

        private int sumTilt(TreeNode node) {
            if (node == null) return 0;
            int left = sumTilt(node.left);
            int right = sumTilt(node.right);
            tilt += Math.abs(left - right);
            return left + right + node.val;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        int i = new Solution().findTilt(root);
        System.out.println(i);
    }
}
