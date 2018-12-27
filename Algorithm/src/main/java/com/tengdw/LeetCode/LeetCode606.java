package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 根据二叉树创建字符串
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 16:27
 */
public class LeetCode606 {
    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) return "";
            StringBuilder sb = new StringBuilder();
            tree2str(t, sb);
            return sb.toString();
        }

        private void tree2str(TreeNode node, StringBuilder sb) {
            if (node == null) return;

            sb.append(node.val);
            if (node.left != null) {
                sb.append("(");
                tree2str(node.left, sb);
                sb.append(")");
            }
            if (node.left == null && node.right != null) {
                sb.append("()(");
                tree2str(node.right, sb);
                sb.append(")");
            } else if (node.right != null) {
                sb.append("(");
                tree2str(node.right, sb);
                sb.append(")");
            }
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4]");
        String s = new Solution().tree2str(root);
        System.out.println(s);
    }
}
