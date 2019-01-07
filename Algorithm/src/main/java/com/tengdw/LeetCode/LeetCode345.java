package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 反转字符串中的元音字母
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 16:43
 */
public class LeetCode345 {
    class Solution {
        public String reverseVowels(String s) {
            if("".equals(s)||s.trim().length()<=1) return s;
            int head = 0;
            int tail = s.length() - 1;
            char[] chars = s.toCharArray();
            while (head < tail) {
                if (!isVowel(chars[head])) {
                    head++;
                    continue;
                }
                if (!isVowel(chars[tail])) {
                    tail--;
                    continue;
                }
                char temp = chars[head];
                chars[head] = chars[tail];
                chars[tail] = temp;
                head++;
                tail--;
            }
            return new String(chars);
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }

    @Test
    public void test() {
        String str = new Solution().reverseVowels(".,");
        System.out.println(str);
    }
}
