package com.tengdw.LeetCode;

/**
 * 字符串中的第一个唯一字符
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-01 18:50
 **/
public class LeetCode387 {
    class Solution {
        public int firstUniqChar(String s) {
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++)
                ints[s.charAt(i) - 'a']++;
            for (int i = 0; i < s.length(); i++)
                if (ints[s.charAt(i) - 'a'] == 1)
                    return i;
            return -1;
        }
    }
}
