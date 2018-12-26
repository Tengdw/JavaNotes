package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 11:45
 */
public class LeetCode173 {
    class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode cur = null;
        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            cur = stack.pop();
            int minVal = cur.val;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return minVal;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[7,3,15,null,null,9,20]");
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

}
