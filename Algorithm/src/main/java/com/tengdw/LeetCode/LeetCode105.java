package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/24 17:05
 */
public class LeetCode105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) return null;
            //前序遍历的第一个访问的就是根节点
            return null;
        }

    }

    @Test
    public void test() {
        int[] preOrder = new int[]{1, 2, 3}; // 3,9,20,15,7
        int[] inOrder = new int[]{3, 2, 1}; // 9,3,15,20,7
        TreeNode root = new Solution().buildTree(preOrder, inOrder);
        System.out.println();
    }
}
