package com.tengdw.LeetCode;


import java.util.*;

/**
 * N叉树的前序遍历
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/18 17:52
 */
public class Problem589 {

    class Solution {
        /*
        //递归与迭代写法和590题差不多
        private List<Integer> list = new ArrayList<>();
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return list;
            }
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
            return list;
        }
        */
        public List<Integer> preorder(Node root) {
            List<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node n = stack.pop();
                list.add(n.val);
                //颠倒每一层的入栈顺序
                for (int i = n.children.size() - 1; i >= 0; i--) {
                    stack.push(n.children.get(i));
                }
            }
            return list;
        }

    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
