package com.tengdw.LeetCode;

import com.tengdw.DataStructure.LinkedList.LinkedList;
import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

/**
 * 二叉树的完全性检验
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/4 15:22
 */
public class LeetCode958 {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);
            TreeNode cur;
            while ((cur = list.removeFirst()) != null) {
                list.addLast(cur.left);
                list.addLast(cur.right);
            }
            while (!list.isEmpty())
                if (list.removeLast() != null)
                    return false;
            return true;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4,5,null,7]");
        boolean completeTree = new Solution().isCompleteTree(root);
        System.out.println(completeTree);
    }
}
