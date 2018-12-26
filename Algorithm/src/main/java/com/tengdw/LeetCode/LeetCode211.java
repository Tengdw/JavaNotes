package com.tengdw.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 添加与搜索单词 - 数据结构设计
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-26 23:04
 **/
public class LeetCode211 {
    class WordDictionary {

        private class Node {
            public boolean isWord;
            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            //这个位置之前没有存放word这个单词
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node node, String word, int index) {
            if (index == word.length())
                return node.isWord;
            char c = word.charAt(index);
            if (c != '.') {
                if (node.next.get(c) == null)
                    return false;
                return search(node.next.get(c), word, index + 1);
            } else { // c == '.'
                //去word中.前面一个字母的所有节点中查找
                for (Map.Entry<Character, Node> entry : node.next.entrySet())
                    if (search(entry.getValue(), word, index + 1))
                        return true;
                return false;
            }
        }
    }
}
