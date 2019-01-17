package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 有效的山脉数组
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/17 16:21
 */
public class LeetCode941 {
    class Solution {
        public boolean validMountainArray(int[] A) {
            int maxIndex = 0;
            for (int i = 0; i < A.length; i++)
                if (A[i] > A[maxIndex]) maxIndex = i;
            if (maxIndex == 0 || maxIndex == A.length - 1) return false;
            for (int i = 1; i <= maxIndex; i++)
                if (A[i - 1] >= A[i]) return false;
            for (int i = maxIndex; i + 1 < A.length; i++)
                if (A[i] <= A[i + 1]) return false;
            return true;
        }
    }

    @Test
    public void test() {
        int[] A = {5,5,3};
        boolean ans = new Solution().validMountainArray(A);
        System.out.println(ans);
    }
}
