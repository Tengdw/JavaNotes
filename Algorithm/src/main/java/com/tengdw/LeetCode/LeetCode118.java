package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
            if (numRows == 0) return result;
            result.add(Arrays.asList(1));
            for (int i = 1; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> pre = result.get(result.size() - 1);
                list.add(1);
                for (int j = 1; j < pre.size(); j++) {
                    list.add(j, pre.get(j - 1) + pre.get(j));
                }
                list.add(1);
                result.add(list);
            }
            return result;
        }
    }

    @Test
    public void test() {
        List<List<Integer>> result = new Solution().generate(2);
        System.out.println(result);
    }
}
