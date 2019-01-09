package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 按奇偶排序数组
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/9 16:22
 */
public class LeetCode905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int i = 0, j = A.length - 1;
            while (j > i) {
                //A[i]是偶数不用交换
                if ((A[i] % 2) == 0) {
                    i++;
                    continue;
                }
                //A[j]是奇数不用交换
                if ((A[j] % 2) == 1) {
                    j--;
                    continue;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            return A;
        }
    }

    @Test
    public void test() {
        System.out.println((1&1) == 1);
        int[] ints = new Solution().sortArrayByParity(new int[]{3,1,2,4});
        System.out.println(Arrays.toString(ints));
    }
}
