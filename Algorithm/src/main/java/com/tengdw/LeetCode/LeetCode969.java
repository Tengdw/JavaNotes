package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 煎饼排序
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/21 16:57
 */
public class LeetCode969 {
    class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> result = new ArrayList<>();
            int maxIndex = 0;
            int n = A.length;
            while (n > 0) {
                for (int i = 0; i < n; i++)
                    if (A[i] > A[maxIndex])
                        maxIndex = i;
                if (maxIndex != n - 1) {
                    rotate(A, maxIndex);
                    result.add(maxIndex + 1);
                }
                rotate(A, --n);
                result.add(n);
                maxIndex = n - 1;
            }
            return result;
        }

        private void rotate(int[] A, int end) {
            int start = 0;
            while (start < end) {
                int temp = A[start];
                A[start++] = A[end];
                A[end--] = temp;
            }
        }
    }

    @Test
    public void test() {
        /*
        3,2,4,1
        4,2,3,1 3
        1,3,2,4 4
        3,1,2,4 2
        2,1,3,4 3
        1,2,3,4 1
         */
        int[] A = {3,2,4,1,6,5,7,8,10,9};
        List<Integer> ans = new Solution().pancakeSort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(ans);
    }
}
