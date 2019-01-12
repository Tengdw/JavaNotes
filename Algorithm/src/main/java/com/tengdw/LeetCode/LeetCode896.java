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
            int len = A.length - 1;
            if (len == 0) return true;
            int l = 0;
            int flag = A[0] > A[len] ? 1 : -1;
            while (l * 2 <= len) {
                if (l * 2 == len)
                    return (A[l] > A[l+1] ? 1 : -1) == flag;
                int temp = A[l] > A[len - l] ? 1 : -1;
                if (temp != flag) return false;
                l++;
            }
            return true;
        }
    }

    @Test
    public void test() {
        int[] A = {9};
        boolean monotonic = new Solution().isMonotonic(A);
        System.out.println(monotonic);
    }
}
