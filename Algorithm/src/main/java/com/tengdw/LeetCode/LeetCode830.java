package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 较大分组的位置
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 10:50
 */
public class LeetCode830 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> result = new ArrayList<>();
            char c = S.charAt(0);
            int start = 0, end = 0;
            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i) == c) {
                    end++;
                } else {
                    if (end - start >= 2) {
                        result.add(Arrays.asList(start, end));
                    }
                    c = S.charAt(i);
                    start = i;
                    end = i;
                }
            }
            if (end - start >= 2) {
                result.add(Arrays.asList(start, end));
            }
            return result;
        }
    }

    //双指针
    class Solution1 {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> result = new ArrayList<>();
            int start = 0, end = 0, len = S.length();
            while (end < len) {
                while (end < len && S.charAt(start) == S.charAt(end))
                    end++;
                if (end - start >= 3)
                    result.add(Arrays.asList(start, end - 1));
                start = end;
            }
            return result;
        }
    }

    @Test
    public void test() {
        String S = "abcdddeeeeaabbbcd";
        List<List<Integer>> result = new Solution1().largeGroupPositions(S);
        System.out.println(result);
    }
}
