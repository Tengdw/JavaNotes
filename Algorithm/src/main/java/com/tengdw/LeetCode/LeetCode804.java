package com.tengdw.LeetCode;

import java.util.TreeSet;

/**
 * 唯一摩尔斯密码词
 * https://leetcode.com/problems/unique-morse-code-words/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-19 23:08
 **/
public class LeetCode804 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            TreeSet<String> set = new TreeSet<>();
            for (String word : words) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    res.append(code[word.charAt(i) - 'a']);
                }
                set.add(res.toString());
            }
            return set.size();
        }
    }
}
