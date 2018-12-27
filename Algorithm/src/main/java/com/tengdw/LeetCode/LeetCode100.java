package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 相同的树
 * https://leetcode.com/problems/same-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 11:21
 */
public class LeetCode100 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p != null && q != null && p.val == q.val)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            else
                return false;
        }
    }
}
