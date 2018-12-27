package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 把二叉搜索树转换为累加树
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 11:43
 */
public class LeetCode538 {
    class Solution {
        TreeNode pre;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            //改变下节点的访问顺序 右孩子->父节点->左孩子
            convertBST(root.right);
            if (pre != null)
                root.val += pre.val;
            pre = root;
            convertBST(root.left);

            return root;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[5,2,13]");
        TreeNode treeNode = new Solution().convertBST(root);
        System.out.println();
    }
}
