package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/24 14:25
 */
public class LeetCode257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            String str = "";
            binaryTreePaths(root, str, result);
            return result;
        }

        private void binaryTreePaths(TreeNode node, String str, List<String> result) {
            if (node == null) return;
            if ("".equals(str))
                str += node.val;
            else
                str += "->" + node.val;
            //叶子节点
            if (node.left == null && node.right == null) {
                result.add(str);
                str = ""; //这里清空的这是叶子节点的 "->" + node.val 后面有return这步可省略
                return;
            }
            binaryTreePaths(node.left, str, result);
            binaryTreePaths(node.right, str, result);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,null,5]");
        List<String> list = new Solution().binaryTreePaths(root);
        System.out.println(list);
    }
}
