package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 路径总和 III
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 9:47
 */
public class LeetCode437 {
    // 双重递归 第二个递归从当前节点开始向下搜索所有节点的和
    class Solution {
        int result = 0;
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            preOrder(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
            return result;
        }

        private void preOrder(TreeNode node, int sum) {
            if (node == null) return;
            sum -= node.val;
            if (sum == 0)
                result++;
            preOrder(node.left, sum);
            preOrder(node.right, sum);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int i = new Solution().pathSum(root, 8);
        System.out.println(i);
    }
}
