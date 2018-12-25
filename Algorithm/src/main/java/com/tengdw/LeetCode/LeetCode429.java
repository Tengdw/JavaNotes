package com.tengdw.LeetCode;

import java.util.*;

/**
 * N叉树的层序遍历
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 16:05
 */
public class LeetCode429 {
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> list = new ArrayList<>(count);
                //移除这一层的元素 将下一层的元素全部入队
                while (count > 0) {
                    Node node = queue.remove();
                    list.add(node.val);
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                    count--;
                }
                result.add(list);
            }
            return result;
        }
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
