package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 单调数列
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/11 17:38
 */
public class LeetCode896 {
    class Solution {
        public boolean isMonotonic(int[] A) {
            if (A.length == 1) return true;
            int flag = A[A.length - 1] > A[0] ? 1 : -1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] == A[i - 1]) continue;
                int temp = A[i] > A[i - 1] ? 1 : -1;
                if (temp != flag) return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        int[] A = {6,5,4,4};
        boolean monotonic = new Solution().isMonotonic(A);
        System.out.println(monotonic);
    }
}
