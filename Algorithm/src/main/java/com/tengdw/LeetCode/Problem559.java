package com.tengdw.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * N叉树的最大深度
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 14:55
 */
public class Problem559 {
    class Solution {
        //层序遍历
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int depth = 0;
            LinkedList<Node> queue = new LinkedList<>();
            queue.addFirst(root);
            while (!queue.isEmpty()) {
                depth++;
                int count = queue.size();
                // 将下一层的所有元素入队
                while (count > 0) {
                    Node temp = queue.pop();
                    if (temp.children != null && temp.children.size() > 0) {
                        queue.addAll(temp.children);
                    }
                    count--;
                }
            }
            return depth;
        }

        public int maxDepthDFS(Node root) {
            if (root == null) return 0;
            int maxDepth = 0;
            for (Node node : root.children) {
                if (node != null) {
                    maxDepth = Math.max(maxDepth, maxDepthDFS(node));
                }
            }
            return maxDepth + 1;
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
