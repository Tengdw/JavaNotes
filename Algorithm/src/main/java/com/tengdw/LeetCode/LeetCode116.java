package com.tengdw.LeetCode;

/**
 * 填充同一层的兄弟节点
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-05 20:43
 **/
public class LeetCode116 {
    class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) return;
            TreeLinkNode levelStart = root;
            while (levelStart != null) {
                TreeLinkNode cur = levelStart;
                while (cur != null) {
                    if (cur.left != null)
                        cur.left.next = cur.right;
                    if (cur.right != null && cur.next != null)
                        cur.right.next = cur.next.left;
                    cur = cur.next;
                }
                levelStart = levelStart.left;
            }
        }
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
