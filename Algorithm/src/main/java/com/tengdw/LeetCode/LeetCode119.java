package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/15 15:48
 */
public class LeetCode119 {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            for (int i = 1; i < rowIndex + 1; i++) {
                List<Integer> pre = new ArrayList<>(result);
                for (int j = 1; j < pre.size(); j++) {
                    result.set(j, pre.get(j) + pre.get(j - 1));
                }
                result.add(1);
            }
            return result;
        }
    }

    //二项式定理
    class Solution1 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>(rowIndex + 1);
            long nCk = 1;
            for (int i = 0; i <= rowIndex; i++) {
                result.add((int) nCk);
                nCk = nCk * (rowIndex - i) / (i + 1);
            }
            return result;
        }
    }

    @Test
    public void test() {
        List<Integer> result = new Solution1().getRow(31);
        System.out.println(result);
    }
}
