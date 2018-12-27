package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * 键值映射
 * https://leetcode.com/problems/map-sum-pairs/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-26 23:33
 **/
public class LeetCode677 {
    class MapSum {

        private class Node {
            public int value;
            public TreeMap<Character, Node> next;

            public Node(int value) {
                this.value = value;
                next = new TreeMap<>();
            }

            public Node() {
                this(0);
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            cur.value = val;
        }

        public int sum(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null)
                    return 0;
                cur = cur.next.get(c);
            }
            return sum(cur);
        }

        // prefix的value值以及以prefix为前缀的单词的value值
        // 即遍历Node子树 求和所有节点的value
        private int sum(Node node) {
            int res = node.value;
            for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                res += sum(entry.getValue());
            }
            return res;
        }
    }

    @Test
    public void test() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap")); // 5
    }
}
