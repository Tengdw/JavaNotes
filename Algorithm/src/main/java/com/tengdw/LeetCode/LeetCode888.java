package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 公平的糖果交换
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-11 23:34
 **/
public class LeetCode888 {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int suma = 0, sumb = 0;
            for (int i = 0; i < A.length; i++)
                suma += A[i];
            for (int i = 0; i < B.length; i++)
                sumb += B[i];
            int AVGdif = (sumb - suma) / 2;
            Set<Integer> set = new HashSet<>();
            for (int i : B)
                set.add(i);
            for (int i : A)
                if (set.contains(AVGdif + i))
                    return new int[]{i, AVGdif + i};
            return null;
        }
    }

    @Test
    public void test() {
        int[] A = {1,2,5};
        int[] B = {2,4};
        int[] ints = new Solution().fairCandySwap(A, B);
        System.out.println(Arrays.toString(ints));
    }
}
