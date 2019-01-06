package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-06 23:40
 **/
public class LeetCode450 {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            } else {
                if (root.left == null) {
                    TreeNode right = root.right;
                    root.right = null; //删除引用
                    return right;
                }
                if (root.right == null) {
                    TreeNode left = root.left;
                    root.left = null;
                    return left;
                }
                TreeNode successor = minimum(root.right);
                successor.right = removeMin(root.right);
                successor.left = root.left;
                root.left = root.right = null;
                return successor;
            }
        }

        private TreeNode minimum(TreeNode node) {
            if (node.left == null) {
                return node;
            }
            return minimum(node.left);
        }

        private TreeNode removeMin(TreeNode node) {
            if (node.left == null) {
                //存在没有左子节点的情况，那么删除的就是当前的节点，然后右子节点替换到当前位置
                TreeNode rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            node.left = removeMin(node.left);
            return node;
        }
    }
}
