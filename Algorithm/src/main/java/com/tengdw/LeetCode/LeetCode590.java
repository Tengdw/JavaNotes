package com.tengdw.LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/18 16:07
 */
public class LeetCode590 {

    /*
    //递归写法
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
*/
    //迭代写法
    //根据先序后序遍历的规律，可知后序的反转其实是先序（不过子节点是由右至左了）。
    //那么，在实现时候，让子节点的出栈顺序先右后左（即入栈时先左后右，和上一题先序遍历正好是相反），最后结果序列反转即可。
    //注：LinkedList可以很方便地在头部插入元素，效果和尾部插入后反转一样。
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            list.addFirst(n.val);
            for (Node node : n.children) {
                stack.push(node);
            }
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
