package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/14 17:59
 */
public class LeetCode118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>(numRows);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            for (int i = 1; i < numRows; i++) {
                for (int j = 1; j < i; j++) {
                    list.add(j, list.get(j - 1) + list.get(j));
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        List<List<Integer>> result = new Solution().generate(5);
        System.out.println(result);
    }
}
