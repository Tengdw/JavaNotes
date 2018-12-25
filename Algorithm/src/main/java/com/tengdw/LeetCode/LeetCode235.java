package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 11:05
 */
public class LeetCode235 {
    class Solution {
        // 根据二叉搜索树的性质，左孩子比父节点小，右孩子比父节点大
        // 当p、q两个元素都比父节点小时，去左孩子继续查找
        // 当满足 p.val <= node.val <= q.val 时，node 节点就是pq的公共祖先
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }
}
