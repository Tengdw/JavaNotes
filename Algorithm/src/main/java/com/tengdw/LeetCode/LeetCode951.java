package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 翻转等价二叉树
 *
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 11:41
 */
public class LeetCode951 {
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 != null && root2 != null) {
                if (root1.val == root2.val) {
                    return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) || //如果从某个节点开始后面的子节点全部翻转了
                            (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)); // 只翻转某一个节点的情况，该节点下的其他子节点未翻转
                }
            }
            return false;
        }
    }
}
